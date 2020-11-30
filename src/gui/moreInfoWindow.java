package gui;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.connection.DatabaseEntry;
import database.connection.DatabaseInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
	

public class moreInfoWindow extends JFrame {
	public moreInfoWindow(DatabaseInterface iface, int n, String value) {
		
	super("More Info!");
	//make the window
	//if parameter = 1, then faculty, else project
			JPanel mainPanel = new JPanel();
			JPanel paintPanel;
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			
			if (n == 1) {
				paintPanel = new MoreInfoFacultyPanel(iface, value);
			}
			else {
				paintPanel = new MoreInfoProjectPanel(iface, value);
				
			}
			mainPanel.add(paintPanel);
			
			this.setContentPane(mainPanel);
			
		    //Display the window.
		    this.pack();
		    this.setVisible(true);
	
	
	}
}
