package net.teamwraith.wraithquest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	private static Scanner reader;
	private static List<Quest> qs = new ArrayList<Quest>();
	private static Quest[] quests;
	
	public static Quest[] getQuests() {
		return quests;
	}

	public static void setQuests(Quest[] quests) {
		FileReader.quests = quests;
	}

	public static void fileLister(){
		// Directory path here
		String path = "./quests";
	
		String files;
		File folder = new File (path);
		File[] listOfFiles = folder.listFiles();
	 
		for (File file : listOfFiles) {
	 
			if (file.isFile()) 
			{
				files = file.getAbsolutePath();
				if (files.endsWith(".quest"))
				{
					System.out.println("Was quest file!");
					FileReader.readFile(files);
				}
			}
		}
		
		quests = qs.toArray( new Quest[ qs.size() ] );
	}
	
	private static Quest readFile (String filename){
		File file = new File(filename);
		
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File @ error: "+file.getName() + " @ path "+file.getAbsolutePath() + "\n");
			e.printStackTrace(); // TODO Later, print an error in the gui
		}
		
		String type = reader.nextLine(); // every file starts with the type, e.g. quest
		
		System.out.println(type);
		
		if (type.contains("quest")){
			return readQuestFile(new Quest());
		}else if (type.contains("cutscene")){
			return readCutsceneFile(new Quest());
		}else if (type.contains("character")){
			return readCharacterFile(new Quest());
		}
		
		return new Quest(); // if no type, just return an empty questobject.
	}
	
	private static Quest readQuestFile (Quest quest) {
		boolean taskPoints = false;
		List<Task> tasks = new ArrayList<Task>();
		
		while (reader.hasNext()){
			String line = reader.nextLine();
			System.out.println(line);
			
			if (line.contains("tasks={")) {
				taskPoints = true;
				continue;
			}
			
			if (line.contains("}") && taskPoints){
				taskPoints = false;
				quest.setTasks((Task[]) tasks.toArray(new Task[0]));
			}
			
			if (line.startsWith("type="))
				quest.setType(line.substring(5));
			else if (line.startsWith("name="))
				quest.setName(line.substring(5));
			else if (line.startsWith("description=")){
				String description = line.substring(12);
				// Parsing paragraphs.
				description = description.replaceAll("<p>", "\n\n");
				quest.setDescription(description);
			}
			
			if (taskPoints){
				String[] parameters = line.split("#");
				if (parameters.length == 2){
					tasks.add(new Task(parameters[0],parameters[1]));
				}else{
					tasks.add(new Task(parameters[0],parameters[1],parameters[2]));
				}
			}
		}
		
		System.out.println(quest.getState());
		qs.add(quest);
		
		return quest;
	}
	
	// TODO incomplete
	private static Quest readCharacterFile (Quest quest) {
		return quest;
	}
	
	// TODO incomplete
	private static Quest readCutsceneFile (Quest quest) {
		while (reader.hasNext()){
			String line = reader.nextLine();
		}
		
		return quest;
	}
}

