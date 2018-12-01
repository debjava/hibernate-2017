/***************************/
/*Many To Many Bidirectional*/
/***************************/
/*Drop the table*/
SET FOREIGN_KEY_CHECKS = 0;
drop table IF EXISTS STUDENT_SUBJECT3;
drop table IF EXISTS STUDENT3;
drop table IF EXISTS SUBJECT3;


create table STUDENT3 (
   studentId BIGINT NOT NULL AUTO_INCREMENT,
   firstName VARCHAR(30) NOT NULL,
   PRIMARY KEY (studentId)
);
 
 
create table SUBJECT3 (
   subjectId BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY (subjectId)
);
 
 
CREATE TABLE STUDENT_SUBJECT3 (
    studentId BIGINT NOT NULL,
    subjectId BIGINT NOT NULL,
    PRIMARY KEY (studentId, subjectId),
    CONSTRAINT FK_STUDENT3 FOREIGN KEY (studentId) REFERENCES STUDENT3 (studentId),
    CONSTRAINT FK_SUBJECT3 FOREIGN KEY (subjectId) REFERENCES SUBJECT3 (subjectId)
);