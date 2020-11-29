package database.connection;

import java.util.ArrayList;

import gui.GUI;

public class Main {

	public static DatabaseInterface iface = new DatabaseInterface();
	
	public static void main(String[] args) {
		tests();
	}
	
	public static void tests() {
//		testFaculty();
//		testProject();
//		testColumnNamesParser();
//		testQueryTable();
		testFirstQuery();
//		testGUI();
		
	}
	
	public static void testColumnNamesParser() {
		iface.queryTable("SELECT * FROM professor");
	}
	
	public static void testFirstQuery() {
//		Display the PI, Co_PI, and student information of a project
		iface.query("SELECT * from graduateStudent NATURAL JOIN ResearchAssistant where projectNo = 3002");
	}
	
	public static void testFaculty() {
		//test database query
		iface.query("SELECT * FROM professor");
		
		//test add faculty
		Faculty f = new Faculty(99010, "Ted Moseby", 32, "M", "Tenured", "Math", 101);
		System.out.println(f.addStatement());
		iface.addEntry(f);
		iface.query("SELECT * FROM professor");
		
		//test remove faculty
		System.out.println("Remove Ted Mosbey");
		iface.removeEntry(f);
		iface.query("Select * from professor");
		
	}
	
	public static void testProject() {
		//test project add remove
		Project p = new Project(3004, "Burton", "10/01/99", "3/24/06", 99004);
		System.out.println("===================");
		iface.query("SELECT * from project");
		System.out.println(p.addStatement());
		iface.addEntry(p);
		iface.query("SELECT * from project");
		System.out.println(p.removeStatement());
		iface.removeEntry(p);
		iface.query("SELECT * from project");
		
	}
	public static void testQueryTable() {
		ArrayList<String[]> table = iface.queryTable("SELECT * FROM professor");
		for (String[] row : table) {
			for (String element : row) {
				System.out.print(element + ", ");
			}
			System.out.println("");
		}
		
	}
	public static void testGUI() {
		GUI gui = new GUI();
	}
}
