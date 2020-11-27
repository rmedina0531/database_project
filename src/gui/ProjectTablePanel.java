package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.connection.DatabaseInterface;
import database.connection.Project;

public class ProjectTablePanel extends JPanel{
	private String[] columnNames;
	private Project[] project;
	private JTable jtable;
	
	
	public ProjectTablePanel (DatabaseInterface iface) {
		ArrayList<String[]> table = iface.queryTable("SELECT * from project");
		this.columnNames = table.get(0);
		table.remove(0);
		this.project = new Project[table.size()];
		for (int i = 0; i < table.size(); i++) {
			this.project[i] = new Project(table.get(i));
		}
		Object[][] data = new Object[table.size()][table.get(0).length];
		for(int i=0; i<table.size(); i++) {
			for(int j=0; j<table.get(i).length; j++) {
				data[i][j] = table.get(i)[j];
			}
		}
		//Table stuff
		jtable = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(jtable);
		this.add(scrollPane);
				
	}
}

