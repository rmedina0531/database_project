package gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import database.connection.DatabaseInterface;

public class GUI extends JFrame{
	public DatabaseInterface iface = new DatabaseInterface();
	JPanel mainPanel = new JPanel();
	public GUI() {
		//Create and set up the window.
	    JFrame frame = new JFrame("SimpleTableDemo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    //main panel
	    this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	    JPanel paintPanel = new FacultyTablePanel(iface);
//	    JPanel paintPanel2 = new ProjectTablePanel(iface);
//	    JPanel textPanel = new JPanel();

	    mainPanel.add(paintPanel);
//	    mainPanel.add(paintPanel2);
	    
	    frame.setContentPane(mainPanel);
	
	    //Display the window.
	    frame.pack();
	    frame.setVisible(true);
	}
}
