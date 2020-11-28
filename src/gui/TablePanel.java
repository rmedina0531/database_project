package gui;


import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connection.DatabaseInterface;

public class TablePanel extends JPanel{
	private String[] columnNames;
	private ArrayList<String[]> table;
	private String tableQuery;
	
	private JTable jtable;
	protected JButton addButton;
	protected JButton removeButton;
	private DefaultTableModel tableModel;
	
	protected DatabaseInterface iface;
	
	public TablePanel (DatabaseInterface iface, String query) {
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
		
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		
		//vertival panel
		//contains the table and the text boxes
		JScrollPane scrollPane = new JScrollPane(jtable);
		this.add(scrollPane);
		this.add(addButton);
		this.add(removeButton);
				
	}
	
	private void refreshTable() {
		//remove all the rows
		if (tableModel.getRowCount() > 0) {
		    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
		    	tableModel.removeRow(i);
		    }
		}
		//run querey and add rows to table
		table = iface.queryTable(this.tableQuery);
		table.remove(0);
		for (int i = 0; i < table.size(); i++) {
			tableModel.addRow(table.get(i));
		}
		//refresh the table
		tableModel.fireTableDataChanged();
	}
}
