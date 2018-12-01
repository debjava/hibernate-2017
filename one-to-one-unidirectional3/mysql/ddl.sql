/***************************/
/*One To One Unidirectional*/
/***************************/
/*Drop the table*/
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS Student;
drop table IF EXISTS Subject;

/*Create the required tables*/

CREATE TABLE IF NOT EXISTS Subject (
  subjectId int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (subjectId)
) ;

CREATE TABLE IF NOT EXISTS Student (
  studentId int(11) NOT NULL AUTO_INCREMENT,
  firstName varchar(255) DEFAULT NULL,
  subjectId int(11) DEFAULT NULL,
  PRIMARY KEY (studentId),
  FOREIGN KEY (subjectId) REFERENCES Subject (subjectId)
) ;


/*Select the created table*/
select * from Student;
select * from Subject;
