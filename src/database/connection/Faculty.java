package database.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//create table professor(SSN int NOT NULL, name varchar(255), age int, gender varchar(1), rank varchar(255),
//researchSpecialty varchar(255), worksAt int Not Null, PRIMARY KEY (SSN));
public class Faculty implements DatabaseEntry{
	private int SSN;
	private String name;
	private int age;
	private String gender;
	private String rank;
	private String researchSpecialty;
	private int worksAt;
	
	
	public Faculty() {};
	
	public Faculty(int ssn, String name, int age, String gender, String rank, String researchSpecialy, int worksAt) {
		this.SSN = ssn;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.rank = rank;
		this.researchSpecialty = researchSpecialy;
		this.worksAt = worksAt;
	}
	
	public Faculty(String[] data) {
		this.setElements(data);
	}
	
	public Faculty(ResultSet r) {
		try {
			this.SSN = Integer.parseInt(r.getString(0));
			this.name = r.getString(1);
			this.age = Integer.parseInt(r.getString(2));
			this.gender = r.getString(3);
			this.rank = r.getString(4);
			this.researchSpecialty = r.getString(5);
			this.worksAt = Integer.parseInt(r.getString(6));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String addStatement() {
		String output = "Insert into professor Values("+this.SSN+",'"+this.name+"',"
				+this.age+",'"+this.gender+"','"+this.rank+"','"+this.researchSpecialty+"',"+this.worksAt+");";
		return output;
	}
	@Override
	public String removeStatement() {
		String output = "DELETE FROM professor where SSN=" + this.SSN;
		return output;
	}

	@Override
	public String[] variables() {
		String[] list = new String[] {"SSN", "name", "age", "gender", "rank", "researchSpecialty", "worksAt"};
		return list;
	}

	@Override
	public void setElements(String[] values) {
		// TODO Auto-generated method stub
		this.SSN = Integer.parseInt(values[0]);
		this.name = values[1];
		this.age = Integer.parseInt(values[2]);
		this.gender = values[3];
		this.rank = values[4];
		this.researchSpecialty = values[5];
		this.worksAt = Integer.parseInt(values[6]);
	}
}

