--add triggers

--First Trigger
CREATE FUNCTION faculty_restrict() RETURNS Trigger AS'
	DECLARE   						 
		total_people int4 :=0;
	BEGIN
		SELECT COUNT(ssn) INTO total_people
		FROM CoInvestigator
		WHERE projectNo = NEW.projectNo;
		IF total_people=4
			THEN RAISE EXCEPTION ''Cannot have more than 4 CoInvestigators'';
		END IF;
		return New;                	 
	END;
'LANGUAGE 'plpgsql';

CREATE TRIGGER faculty_restrict
	BEFORE INSERT OR UPDATE
	ON coinvestigator
	FOR EACH ROW
	EXECUTE PROCEDURE faculty_restrict();

--Second Trigger
CREATE FUNCTION student_restrict() RETURNS Trigger AS'
	DECLARE                       	 
		total_projects int4 :=0;
	BEGIN
		SELECT COUNT(projectNo) INTO total_projects
		FROM ResearchAssistant
		WHERE SSN = NEW.SSN;
		IF total_projects=2
			THEN RAISE EXCEPTION ''Student cannot work on more than 2 projects'';
		END IF;
		return New;                	 
	END;
'LANGUAGE 'plpgsql';

CREATE TRIGGER student_restrict
BEFORE INSERT OR UPDATE
ON ResearchAssistant
FOR EACH ROW
EXECUTE PROCEDURE student_restrict();

