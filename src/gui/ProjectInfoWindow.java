package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import database.connection.DatabaseInterface;
import database.connection.Project;

public class ProjectInfoWindow extends JFrame {
	JLabel piLabel;
	JTable co_piTable;
	JTable research_assistants;
	
	
	public ProjectInfoWindow(DatabaseInterface iface, Project project) {
		this.piLabel = new JLabel(project.getProjectNo() + "");
	}
}
