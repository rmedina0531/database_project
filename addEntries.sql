/*
begin;
Insert into professor
Values(99001,'Bob Barker',60,'M', 'Tenured','Math', 101);

Insert into professor
Values(99002,'Mary Tyler Moore', 45, 'F', 'Guest','English', 102);

Insert into professor
Values(99003,'Earthworm Jim', 35, 'M', 'Adjunct', 'Math', 101);

Insert into professor
Values(99004, 'Stephanie Beatriz',38, 'F', 'Adjunct', 'Math', 101);

Insert into professor
Values(99005, 'Samwell Tarley', 42, 'M', 'Tenured', 'English', 102);

INSERT INTO department
Values (101, 'Math', 'Room1', 99001);

INSERT INTO department
Values (102, 'English', 'Room2', 99002);
Commit;
*/

/*
Begin;
Insert into project
values(3001,'Nike','11/10/20','01/14/21',99001);

Insert into project
values(3002,'Addidas','11/22/20','11/14/23', 99002);

Insert into project
values(3003,'Rebock','11/01/20','05/31/22', 99003);
Commit;
*/

/*
begin;
Insert into graduatestudent
Values(11001, 'Peter Parker', 22, 'M', 'Math', 101, 11002);

Insert into graduatestudent
Values(11002, 'Steve Rodgers', 122, 'M', 'English', 102, 11001);
 
Insert into graduatestudent
Values(11003, 'Eliot Reid', 23, 'F', 'Math', 101, 11001);

Insert into graduatestudent
Values(11004, 'John Dorian', 22, 'M', 'English', 102, 11002);

Insert into graduatestudent
Values(11005, 'Christopher Turk', 25, 'M', 'English', 102, 11002);

Insert into graduatestudent
Values(11006, 'Carla Espinosa', 23, 'F', 'Math', 101, 11001);

Insert into graduatestudent
Values(11007,'Jordan Sullivan', 29, 'F', 'Math', 101, 11001);

commit;
*/

begin; 
INSERT INTO CoInvestigator(projectno,ssn)
Values('3001','99001');
INSERT INTO CoInvestigator(projectno,ssn)
Values('3001','99002');
INSERT INTO CoInvestigator(projectno,ssn)
Values('3002','99003');
INSERT INTO CoInvestigator(projectno,ssn)
Values('3003','99004');

INSERT INTO ResearchAssistant(projectno,ssn)
Values('3001','11002');
INSERT INTO ResearchAssistant(projectno,ssn)
Values('3001','11003');
INSERT INTO ResearchAssistant(projectno,ssn)
Values('3002','11006');
INSERT INTO ResearchAssistant(projectno,ssn)
Values('3002','11005');
INSERT INTO ResearchAssistant(projectno,ssn)
Values('3003','11007');
commit;