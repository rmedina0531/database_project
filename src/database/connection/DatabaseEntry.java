package database.connection;

public interface DatabaseEntry {
	public String addStatement();
	public String removeStatement();
	
	public String[] variables();
	public void setElements(String [] values);
}
