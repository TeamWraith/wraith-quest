package net.teamwraith.wraithquest;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JScrollPane;

public class GUIBuild extends JFrame {
	
	private static final long serialVersionUID = 1188114603961808680L;
	
//	Self-explanatory.
	private JPanel contentPane;
//	The password field.
	private JTextField fieldPassword;
//	JButton. Working on making it "look" like a label.
	private JButton buttonLink;
//	Name of the quest.
	private JTextField fieldName;
//	List of complete quests.
	private JList<Object> listCompleteQuests;
//	The description field.
	private JTextArea fieldDescription;
//	The list of tasks.
	private JList<Object> listTasks;
//	The scrollbar for the questlist
	private JScrollPane scrollPane;
	private JList<Object> listQuests;

	//	A pointer back to the object. Mostly for use inside KeyAdapters and such.
	private GUIBuild gui = this;

	
	public JTextField getFieldPassword() {
		return fieldPassword;
	}

	public JButton getButtonLink() {
		return buttonLink;
	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JList<Object> getQuestList() {
		return listQuests;
	}

	public JList<Object> getCompleteQuestList() {
		return listCompleteQuests;
	}

	public JTextArea getFieldDescription() {
		return fieldDescription;
	}

	public JList<Object> getTaskList() {
		return listTasks;
	}

	
	
	public GUIBuild () {
		// Is not fully resizable yet, minimizing it has odd results.
		setResizable(true);
		setTitle("Wraith QuestLogger");
		setFont(new Font("Tahoma", Font.ITALIC, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPassword = new JLabel("Password:");
		JLabel lblLink = new JLabel("Link:");
		JLabel lblQuests = new JLabel("Quests:");

		fieldPassword = new JTextField();
		fieldPassword.setColumns(10);

		buttonLink = new JButton();
		buttonLink.setHorizontalAlignment(SwingConstants.LEFT);
		// Makes the cursor become a click-hand when hovering over the button.
		buttonLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonLink.setBackground(Color.WHITE);
		buttonLink.setForeground(Color.BLUE);
		buttonLink.setOpaque(false);
		buttonLink.setContentAreaFilled(false);
		buttonLink.setBorderPainted(false);
		

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.LIGHT_GRAY);

		JLabel lblCompleteQuests = new JLabel("Completed Quests:");

		listCompleteQuests = new JList<Object>();
		listCompleteQuests
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCompleteQuests.setBackground(Color.LIGHT_GRAY);
		
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblQuests)
							.addComponent(listCompleteQuests, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addComponent(lblCompleteQuests, Alignment.LEADING))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPassword, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
						.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLink)
							.addGap(18)
							.addComponent(buttonLink, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuests)
						.addComponent(lblPassword)
						.addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonLink)
								.addComponent(lblLink))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCompleteQuests)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listCompleteQuests, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		listQuests = new JList<Object>();
		listQuests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listQuests.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(listQuests);
				
		fieldName = new JTextField();
		fieldName.setEditable(false);
		fieldName.setColumns(10);

		fieldDescription = new JTextArea(10,50);
		fieldDescription.setEditable(false);
		fieldDescription.setLineWrap(true);
		fieldDescription.setWrapStyleWord(true);
		
		listTasks = new JList<Object>();
		listTasks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// unreadable
		GroupLayout gl_infoPanel = new GroupLayout(infoPanel);
		gl_infoPanel
				.setHorizontalGroup(gl_infoPanel
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_infoPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_infoPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																listTasks,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																341,
																Short.MAX_VALUE)
														.addComponent(
																fieldDescription,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																341,
																Short.MAX_VALUE)
														.addComponent(
																fieldName,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																341,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_infoPanel.setVerticalGroup(gl_infoPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_infoPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(fieldName, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(fieldDescription,
								GroupLayout.PREFERRED_SIZE, 185,
								GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(listTasks, GroupLayout.DEFAULT_SIZE, 272,
								Short.MAX_VALUE).addContainerGap()));
		infoPanel.setLayout(gl_infoPanel);
		contentPane.setLayout(gl_contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{
			contentPane, infoPanel, lblQuests, lblPassword, lblLink, buttonLink, fieldPassword
		}));
		
		// CompleteQuestlist's functions, mainly to read completed quests.
		// TODO Make it do something...
		listCompleteQuests
			.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {}
			});
	}	
}