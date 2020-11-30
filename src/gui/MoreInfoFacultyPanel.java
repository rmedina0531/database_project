package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connection.DatabaseEntry;
import database.connection.DatabaseInterface;
import database.connection.Faculty;


public class MoreInfoFacultyPanel extends JPanel{
	private String[] columnNames;
	private ArrayList<String[]> table;
	private String tableQuery;
	
	private JTable jtable;
	protected JButton addButton;
	protected JButton removeButton;
	protected JButton refreshButton;
	protected JButton moreInfoButton;
	private DefaultTableModel tableModel;
	
	private DatabaseInterface iface;
	private DatabaseEntry entry;
	public MoreInfoFacultyPanel (DatabaseInterface iface, String SSN) {	
		
		
		String x = SSN;
		String query = "select prof.name as Professor, stu.name as Student, ra.projectno as Works_On_Project from professor prof, graduatestudent stu, department d, researchassistant ra where ra.ssn= stu.ssn and stu.belongstodept=d.dno and prof.ssn= d.deptchair and prof.ssn= " + x + ";";
		
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
		
		//contains the table and the text boxes
				JScrollPane scrollPane = new JScrollPane(jtable);
				this.add(scrollPane);
		
		
		
		
		
	}
	

}
