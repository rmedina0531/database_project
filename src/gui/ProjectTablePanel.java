package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

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
		
		this.removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeProjectEvent();
			}
		});
		
		this.moreInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moreInfoProjectWindow();
			}
		});
	}
	
	private void addProjectWindow() {
		//create and show new window
		Project p = new Project();
		AddElementWindow window = new AddElementWindow(p, this.iface);
	}
	
	private void removeProjectEvent() {
		super.removeEntryEvent(new Project());
	}
	
	private void moreInfoProjectWindow() {
		//create and show new window
		
		if (jtable.getSelectedColumn() != -1) {
			String x =(String) ((Vector) super.tableModel.getDataVector().elementAt(super.jtable.getSelectedRow())).elementAt(0);
			//System.out.print(x);
			String projectNo = x;
			moreInfoWindow window = new moreInfoWindow(this.iface,0, projectNo);
		}
		
	}
}
