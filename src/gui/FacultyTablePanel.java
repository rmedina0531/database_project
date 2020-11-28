package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import database.connection.DatabaseInterface;
import database.connection.Faculty;

public class FacultyTablePanel extends JPanel{
	private String[] columnNames;
	private Faculty[] faculty;
	private JTable jtable;
	private JButton addButton;
	private JButton removeButton;
	
	private DatabaseInterface iface;
	
	
	
	public FacultyTablePanel (DatabaseInterface iface) {
		this.iface = iface;
		
		ArrayList<String[]> table = iface.queryTable("SELECT * FROM professor");
		this.columnNames = table.get(0);
		table.remove(0);
		this.faculty = new Faculty[table.size()];
		for (int i = 0; i < table.size(); i++) {
			this.faculty[i] = new Faculty(table.get(i));
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
		
		addButton = new JButton("Add Faculty");
		
		this.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFacultyWindow();
			}
		});
		
		removeButton = new JButton("Remove Faculty");
		
		//vertival panel
		//contains the table and the text boxes
		this.add(scrollPane);
		this.add(addButton);
		this.add(removeButton);
				
	}
	
	private void refresh() {
		jtable.fireTableDataChanged();
	}
	
	private void addFacultyWindow() {
		//create and show new window
		Faculty f = new Faculty();
		AddElementWindow window = new AddElementWindow(f, this.iface);
	}
}
