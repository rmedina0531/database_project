

create table professor(SSN int NOT NULL, name varchar(255), age int, gender varchar(1), rank varchar(255),
						researchSpecialty varchar(255), worksAt int Not Null, PRIMARY KEY (SSN));
						
create table department(DNO int NOT NULL, name varchar(255), mainOffice varchar(255),
						deptChair int NOT NULL, PRIMARY KEY (DNO),
						FOREIGN KEY (deptChair) references professor (SSN) on delete restrict
						deferrable initially deferred);
						
alter table professor add FOREIGN KEY(worksAt) references department(DNO) on delete restrict 
						deferrable initially deferred;
						
create table project(projectNo int NOT NULL, sponsorName varchar(255), startingDate varchar(255),
						endingDate varchar(255), principleInvestigator int NOT NULL,
						PRIMARY KEY (projectNo), 
						FOREIGN KEY (principleInvestigator) references professor(SSN) on delete restrict);
						

create table graduateStudent(SSN int NOT NULL, name varchar(255), age int, gender varchar(1),
						degreeProgram varchar(255), belongsToDept int NOT NULL, advisedBy int NOT NULL,
						PRIMARY KEY (SSN));
alter table graduateStudent add FOREIGN KEY (advisedBy) references graduateStudent (SSN) deferrable initially deferred;
						
create table CoInvestigator(SSN int NOT NULL, projectNo int NOT NULL, PRIMARY KEY (SSN, projectNo),
						FOREIGN KEY (SSN) references professor(SSN) ON DELETE RESTRICT,
						FOREIGN KEY (projectNo) references project(projectNo) ON DELETE RESTRICT);
						
create table ResearchAssistant(SSN int NOT NULL, projectNo int NOT NULL,
						PRIMARY KEY (SSN, projectNo),
						FOREIGN KEY (SSN) references graduateStudent (SSN) ON DELETE RESTRICT,
						FOREIGN KEY (projectNo) references project(projectNo) ON DELETE RESTRICT);
						