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
		this.removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeFacultyEvent();
			}
		});
	}
	
	private void addFacultyWindow() {
		//create and show new window
		Faculty f = new Faculty();
		AddElementWindow window = new AddElementWindow(f, this.iface);
	}
	private void removeFacultyEvent() {
		//get the selected row from jtable
////		Faculty f = new Faculty(getRow);
//		iface.removeEntry(f);
//		refreshTable();
		System.out.println("RemoveEvent");
	}
}
