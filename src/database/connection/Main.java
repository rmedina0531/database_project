package database.connection;

public class Main {

	public static DatabaseInterface iface = new DatabaseInterface();
	
	public static void main(String[] args) {
		tests();
	}
	public static void tests() {
//		testFaculty();
		testProject();
		
		
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
}
