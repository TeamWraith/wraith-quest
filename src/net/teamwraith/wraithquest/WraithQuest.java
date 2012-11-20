package net.teamwraith.wraithquest;

import java.awt.EventQueue;
import java.io.File;

public class WraithQuest {
	
	public static void main(String[] args) {
		
		FileReader.fileLister();
		System.out.println("File reader: " + FileReader.getQuests());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI frame = new AppGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
}
