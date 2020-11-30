package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
				moreInfoFacultyWindow();
			}
		});
	}
	
	private void addFacultyWindow() {
		//create and show new window
		Faculty f = new Faculty();
		AddElementWindow window = new AddElementWindow(f, this.iface);
	}
	
	private void moreInfoFacultyWindow() {
		//create and show new window
		
		if (jtable.getSelectedColumn() != -1) {
			String x =(String) ((Vector) super.tableModel.getDataVector().elementAt(super.jtable.getSelectedRow())).elementAt(0);
			//System.out.print(x);
			String SSN = x;
			moreInfoWindow window = new moreInfoWindow(this.iface, 1, SSN);
		}
		
		
	}
}
