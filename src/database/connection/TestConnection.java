package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Name: Medina, Ricardo
//User Id: cs4222s18
//Pass: CsaMasvT


public class TestConnection {
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
			}else {
				System.out.println("Failed to connect to PostgresSQL server");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		TestConnection sqlConnect = new TestConnection();
//		sqlConnect.connect();
//	}
}
