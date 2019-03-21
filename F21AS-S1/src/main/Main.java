package main;

import view.GUI_Simulation;

public class Main {
	
	/**
	   * This is the main method which makes initiates the
	   * Coffee Shop Simulation GUI.
	   * @param args Unused.
	   * @return Nothing.
	   */

	public static void  main(String[] args){
		
			GUI_Simulation gui = new GUI_Simulation("", "", false);
			
			gui.setVisible(true);
		
	}
}
