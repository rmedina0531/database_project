package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	//add faculty
	//remove faculty
	//add project
	//remove project
	//display the PI, COPI and student info on a project
	//Display all students a professor supervises and the project each student works on
	
	private <E> void addEntry (E entry) {
		try(Connection connection = DriverManager.getConnection(
				url,user,password);){
			if(connection != null) {
				System.out.println("Connected to PostgresSQL server Successfully!");
				
				Statement statement = connection.createStatement();
				statement.executeUpdate(((DatabaseAddStatement) entry).addStatement());

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
	
	public static void main(String[] args) {
		DatabaseInterface sqlConnect = new DatabaseInterface();
		sqlConnect.connect();
	}
}
