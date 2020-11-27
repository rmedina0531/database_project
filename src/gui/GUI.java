package gui;

import javax.swing.JFrame;

import database.connection.DatabaseInterface;

public class GUI extends JFrame{
	public DatabaseInterface iface = new DatabaseInterface();
	public GUI() {
		//Create and set up the window.
	    JFrame frame = new JFrame("SimpleTableDemo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    //Create and set up the content pane.
	    FacultyTablePanel newContentPane = new FacultyTablePanel(iface.queryTable("SELECT * FROM professor"));
	    newContentPane.setOpaque(true); //content panes must be opaque
	    frame.setContentPane(newContentPane);
	
	    //Display the window.
	    frame.pack();
	    frame.setVisible(true);
	}
}
