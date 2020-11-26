package database.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//create table professor(SSN int NOT NULL, name varchar(255), age int, gender varchar(1), rank varchar(255),
//researchSpecialty varchar(255), worksAt int Not Null, PRIMARY KEY (SSN));
public class Faculty implements DatabaseAddRemove{
	private int SSN;
	private String name;
	private int age;
	private String gender;
	private String rank;
	private String researchSpecialty;
	private int worksAt;
	
	public Faculty(int ssn, String name, int age, String gender, String rank, String researchSpecialy, int worksAt) {
		this.SSN = ssn;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.rank = rank;
		this.researchSpecialty = researchSpecialy;
		this.worksAt = worksAt;
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

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getResearchSpecialty() {
		return researchSpecialty;
	}

	public void setResearchSpecialty(String researchSpecialty) {
		this.researchSpecialty = researchSpecialty;
	}

	public int getWorksAt() {
		return worksAt;
	}

	public void setWorksAt(int worksAt) {
		this.worksAt = worksAt;
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
	
	
}
