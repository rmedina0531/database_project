package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connection.DatabaseInterface;

public class MoreInfoWindow extends JFrame{

	private String[] columnNames;
	private ArrayList<String[]> table;
	private String tableQuery;
	
	private JTable jtable;
	private DefaultTableModel tableModel;
	
	protected DatabaseInterface iface;
	
	public MoreInfoWindow (DatabaseInterface iface, String query) {
		this.iface = iface;
		this.tableQuery = query;
		
		jtable = new JTable();
		tableModel = new DefaultTableModel();
		jtable.setModel(tableModel);
		
		table = iface.queryTable(this.tableQuery);
		this.columnNames = table.get(0);
		
		//add columnNames to table
		for (String name : this.columnNames) {
			tableModel.addColumn(name);
		}
		
		table.remove(0);
		for (int i = 0; i < table.size(); i++) {
			tableModel.addRow(table.get(i));
		}		
		//vertival panel
		//contains the table and the text boxes
		JScrollPane scrollPane = new JScrollPane(jtable);
		this.add(scrollPane);
		
		this.setContentPane(scrollPane);
		
	    //Display the window.
	    this.pack();
	    this.setVisible(true);

		
	}
}
