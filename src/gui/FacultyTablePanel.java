package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
		
		this.moreInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtable.getSelectedColumn() != -1) {
			        Object[] objArray = tableModel.getDataVector().elementAt(jtable.getSelectedRow()).toArray();
//			        Convert Object[] to String[] 
			        String[] array = Arrays.copyOf(objArray, 
			                                       objArray.length, 
			                                       String[].class);
			        //need to make the query for the more info
			        String q = "";
			        MoreInfoWindow w = new MoreInfoWindow(iface, "SELECT * FROM professor");
				}
				
				
			}
		});
	}
	
	private void addFacultyWindow() {
		//create and show new window
		Faculty f = new Faculty();
		AddElementWindow window = new AddElementWindow(f, this.iface);
	}
}
