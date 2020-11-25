-- fucntions

CREATE FUNCTION female_faculty() RETURNS float8 AS'
	DECLARE
		f_percent float8 :=1;
		count_total float8;
		count_female float8;
		female TEXT :=0;
	BEGIN
		SELECT Count(ssn) INTO count_total
		FROM professor;

		SELECT Count(ssn) INTO count_female
		FROM professor
		WHERE gender = female;

		f_percent := (count_female/count_total);
		return f_percent;                      	
	END;
'LANGUAGE 'plpgsql';
 
 
CREATE FUNCTION total_people(INTEGER) RETURNS int4 AS'
	DECLARE
		pno ALIAS FOR $1;
		prof_total int4;
		stu_total int4;
		total_people int4 :=0;
	BEGIN
		SELECT COUNT(ssn) INTO stu_total
		FROM RESEARCHASSISTANT
		WHERE projectNo = pno;

		SELECT COUNT(ssn) INTO prof_total
		FROM CoInvestigator
		WHERE projectNo = pno;
		 
		total_people := (prof_total+stu_total);
		return total_people;                	 
	END;
'LANGUAGE 'plpgsql';
