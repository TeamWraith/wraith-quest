package net.teamwraith.wraithquest;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import net.teamwraith.wraithquest.Quest.QuestState;
import net.teamwraith.wraithquest.Task.TaskState;
public class AppGUI {
	
	private static List<String> activatedQuests;
	private static GUIBuild gui;
	
	/**
	 * Create the frame.
	 */
	public AppGUI() {
		activatedQuests = new ArrayList<String>();
		gui = new GUIBuild();
		gui.setVisible(true);
		
		gui.getButtonLink().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				Desktop desktop = Desktop.getDesktop();
			    if (desktop != null && 
			    	desktop.isSupported(Desktop.Action.BROWSE) && 
			    	!gui.getButtonLink().getText().isEmpty()) {
			     
			    	try {
			    		// Opens the link. Will not open the file browser if the field is empty.
			            desktop.browse(new URI(gui.getButtonLink().getText()));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    	
			    }
			}
			
		});
		
		// Passwordfield's functions
		gui.getFieldPassword().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					refresh(gui.getFieldPassword().getText());
				}
			}
		});
	}

	public static String[] getTaskPoints(Quest quest){
		System.out.println(quest.getTasks().length);
		Task[] tasks = quest.getTasks();
		String[] taskPoints = new String[tasks.length];
		
		for (int i = 0; i < tasks.length; i++){
			taskPoints[i] = tasks[i].getTaskPoint();
		}
		
		return taskPoints;
	}

	public static void redirect(String questName) {
		JList<Object> questList = gui.getQuestList();
		
		for (int i = 0; i < questList.getModel().getSize(); i++) {
			gui.getQuestList().setSelectedIndex(i);
			if (questList.getModel().getElementAt(i).equals(questName)) {
				return;
			}
		}
	}

	public static void redirect(int index, List<String> taskpoints, Quest quest) {
		gui.getQuestList().setSelectedIndex(index);
		refreshAll(taskpoints, quest);
	}
	
	public static void refreshAll(List<String> taskpoints, Quest quest){
		
		refreshQuestList(activatedQuests
				.toArray( new String[ activatedQuests.size() ] ), gui);
		refreshTaskList(taskpoints
				.toArray( new String[ taskpoints.size() ] ), gui, quest.getCurrentTask());
		refreshDescription(quest, gui);
		
		gui.getFieldName().setText(quest.getName());
	}

	public static void refresh(String password){
		List<String> taskpoints = new ArrayList<String>();
		
		int i = 0;
		for (Quest quest : FileReader.getQuests()) {
			i++;
			
			// Assign task to the quest's current task.
			Task task = quest.getTasks()[quest.getCurrentTask()];
			
			// Check if the password is equal to the quest's current task.
			if (password.equals(task.getPassword())) {
				if (task.getState() == TaskState.NOT_ACTIVATED) {
					task.setState(TaskState.ACTIVATED);
					System.out.println("Current task added: "
							+ task.getTaskPoint());
					// u2022 = bullet point
					taskpoints.add("\u2022 " + task.getTaskPoint());
				}

				// If quest hasn't started, i.e. current task = 0.
				if (quest.getCurrentTask() == 0) {
					quest.setState(QuestState.STARTED);
				}

				if (quest.getState() == QuestState.STARTED) {
					System.out.println("Activated name of quest: "
							+ quest.getName());
					if (!activatedQuests.contains(quest.getName())){
						activatedQuests.add(quest.getName());
					}
				}
				
				quest.setCurrentTask(quest.getCurrentTask()+1);
				redirect(i, taskpoints, quest);
				break;
			}
		}
	}
	
	public static void refreshQuestList(String[] quests, GUIBuild gui) {
		gui.getQuestList().setListData(quests);
	}

	public static void refreshTaskList(String[] tasks, GUIBuild gui, int questpoint) {
		String[] t = new String[tasks.length];
		System.out.println("amount of tasks: "+tasks.length);
		
		t[0] = tasks[0];
		
		gui.getTaskList().setListData(t);
	}
	
	public static void refreshDescription(Quest quest, GUIBuild gui){
		gui.getFieldDescription().setText(quest.getDescription());
	}

	public static void refreshName(Quest quest, GUIBuild gui) {
		gui.getFieldName().setText(quest.getName());
	}
}