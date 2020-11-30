package database.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

//create table project(projectNo int NOT NULL, sponsorName varchar(255), startingDate varchar(255),
//		endingDate varchar(255), principleInvestigator int NOT NULL,
//		PRIMARY KEY (projectNo), 
//		FOREIGN KEY (principleInvestigator) references professor(SSN) on delete restrict);

public class Project implements DatabaseEntry {
	private int projectNo;
	private String sponsorName;
	private String startingDate;
	private String endingDate;
	private int principalInvestigator;
	
	public Project(int projectNo, String sponsorName, String startingDate, 
					String endingDate, int principalInvestigator) {
		this.projectNo = projectNo;
		this.sponsorName = sponsorName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.principalInvestigator = principalInvestigator;
	}
	
	public Project(String[] data) {
		this.setElements(data);
	}
	public Project() {};
	public Project(ResultSet r) {
		try {
			this.projectNo = Integer.parseInt(r.getString(0));
			this.sponsorName = r.getString(1);
			this.startingDate = r.getString(2);
			this.endingDate = r.getString(3);
			this.principalInvestigator = Integer.parseInt(r.getString(4));
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
		// TODO Auto-generated method stub
		String output = "Insert into project Values("+this.projectNo+",'"+this.sponsorName+"','"
				+this.startingDate+"','"+this.endingDate+"',"+this.principalInvestigator+");";
		return output;
	}

	@Override
	public String removeStatement() {
		// TODO Auto-generated method stub
		String output = "DELETE FROM project where projectNo=" + this.projectNo;
		return output;
	}

	//returns the cell variables for the entry
	//used by window to generate the appropriate labels
	@Override
	public String[] variables() {
		String[] list = new String[] {"projectNo", "sponsorName", "startingDate", "endindDate", "principalInvestigator"};
		return list;
	}

	@Override
	public void setElements(String[] values) {
		// TODO Auto-generated method stub
		this.projectNo = Integer.parseInt(values[0]);
		this.sponsorName = values[1];
		this.startingDate = values[2];
		this.endingDate = values[3];
		this.principalInvestigator = Integer.parseInt(values[4]);
		
	}
	
	
}
