package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connection.DatabaseInterface;
import database.connection.Project;

public class ProjectTablePanel extends TablePanel{
	
	public ProjectTablePanel (DatabaseInterface iface) {
		
		super(iface, "SELECT * FROM project");
		
		this.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addProjectWindow();
			}
		});
	}
	
	private void addProjectWindow() {
		//create and show new window
		Project p = new Project();
		AddElementWindow window = new AddElementWindow(p, this.iface);
	}
}
