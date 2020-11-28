package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.connection.DatabaseEntry;
import database.connection.DatabaseInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
	
public class AddElementWindow extends JFrame{
	private JLabel[] labels;
	private JTextField[] textFields;
	private JButton addButton = new JButton("Add");
	private JButton cancelButton = new JButton("Cancel");
	
	private DatabaseInterface iface;
	private DatabaseEntry entry;
	public AddElementWindow(DatabaseEntry entry, DatabaseInterface iface) {
		super("Add Entry");
		this.iface = iface;
		this.entry = entry;
		//generate the JLabels and text fields
		labels = new JLabel[entry.variables().length];
		textFields = new JTextField[entry.variables().length];
		for (int i = 0; i < entry.variables().length; i++) {
			labels[i] = new JLabel(entry.variables()[i]);
			textFields[i] = new JTextField("",15);
		}
		
//		listenedObject.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent evt) {
//		        listenedObject_actionPerformed(evt);
//		    }
//		});
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addButtonEvent();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelButtonEvent();
			}
		});
		
		
		//make the window
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel[] rows = new JPanel[entry.variables().length];
		JPanel buttonPanel = new JPanel();
		
//		JPanel labelPanel = new JPanel();
//		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
//		JPanel textFieldPanel = new JPanel();
//		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
		
		
		for (int i = 0; i < this.labels.length; i++) {
			rows[i] = new JPanel();
			rows[i].add(this.labels[i]);
			rows[i].add(this.textFields[i]);
			mainPanel.add(rows[i]);
		}
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
		mainPanel.add(buttonPanel);
		
		this.setContentPane(mainPanel);
		
	    //Display the window.
	    this.pack();
	    this.setVisible(true);
	}
	
	public void addButtonEvent() {
		String values[] = new String[this.entry.variables().length];
		for (int i = 0; i < values.length; i++) {
			values[i] = this.textFields[i].getText();
		}
		this.entry.setElements(values);
		this.iface.addEntry(this.entry);
		//add code to close frame
		this.cancelButtonEvent();
	}
	public void cancelButtonEvent() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
