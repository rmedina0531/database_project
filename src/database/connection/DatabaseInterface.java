package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Name: Medina, Ricardo
//User Id: cs4222s18
//Pass: CsaMasvT


public class DatabaseInterface {
	//jdbc url
	//jdbc userName
	//jdbc password
	private final String url = "jdbc:postgresql://cs1.calstatela.edu/";
	private final String user = "cs4222s18";
	private final String password = "CsaMasvT";
	
	private void connect() {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from department");

				while(resultSet.next()) {
					for (int i=1; i<=resultSet.getMetaData().getColumnCount(); i++) {
						System.out.println(resultSet.getString(i));
					}
					System.out.println("New Row");
				}
			}else {
				System.out.println("Failed to connect to PostgresSQL server");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void query(String query) {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				
				System.out.println(query);
				
				while(resultSet.next()) {
					for (int i=1; i<=resultSet.getMetaData().getColumnCount(); i++) {
						if (i > 1) System.out.print(", ");
						String columnValue = resultSet.getString(i);
						System.out.print(resultSet.getMetaData().getColumnName(i) +" "+ columnValue);
					}
					System.out.println("");
				}
			}else {
				System.out.println("Failed to connect to PostgresSQL server");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<String[]> queryTable(String query) {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				
//				System.out.println(query);
				int columnCount = resultSet.getMetaData().getColumnCount();
				ArrayList<String[]> table = new ArrayList<>();
				String[] columnName = new String[columnCount];
				
				for (int i=1; i<=columnCount; i++) {
					columnName[i-1] = resultSet.getMetaData().getColumnName(i);
//					System.out.println(resultSet.getMetaData().getColumnName(i));
				}
				table.add(columnName);
				
//				for (String s : columnName) {
//					System.out.println(s);
//				}
				while (resultSet.next()) {
					String[] row = new String[columnCount];
					for (int i=1; i<=resultSet.getMetaData().getColumnCount(); i++) {
//						if (i > 1) System.out.print(", ");
						String columnValue = resultSet.getString(i);
						row[i-1] = columnValue;
//						System.out.print(resultSet.getMetaData().getColumnName(i) +" "+ columnValue);
					}
					table.add(row);
				}
				return table;
			}else {
				System.out.println("Failed to connect to PostgresSQL server");
				return null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	//add faculty
	//remove faculty
	//add project
	//remove project
	//display the PI, COPI and student info on a project
	//Display all students a professor supervises and the project each student works on
	
	public <E> void addEntry (E entry) {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				statement.executeUpdate(((DatabaseEntry) entry).addStatement());
				System.out.println("Added Successfully");

			}else {
				System.out.println("Failed to connect to PostgresSQL server");
			}
		}catch(SQLException e){
			//Handle errors for JDBC
			e.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
	public <E> void removeEntry (E entry) {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				statement.executeUpdate(((DatabaseEntry) entry).removeStatement());
				
				System.out.println("Removed Successfully");

			}else {
				System.out.println("Failed to connect to PostgresSQL server");
			}
		}catch(SQLException e){
			//Handle errors for JDBC
			e.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
