package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connection.DatabaseInterface;
import database.connection.Faculty;

public class FacultyTablePanel extends TablePanel{
	public FacultyTablePanel (DatabaseInterface iface) {
		
		super(iface, "SELECT * FROM PROFESSOR");
		
		this.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFacultyWindow();
			}
		});
	}
	
	private void addFacultyWindow() {
		//create and show new window
		Faculty f = new Faculty();
		AddElementWindow window = new AddElementWindow(f, this.iface);
	}
}
