drop table IF EXISTS STUDENT_SUBJECT3;
drop table IF EXISTS STUDENT3;
drop table IF EXISTS SUBJECT3;


create table STUDENT3 (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id)
);
 
 
create table SUBJECT3 (
   subject_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY (subject_id)
);
 
 
CREATE TABLE STUDENT_SUBJECT3 (
    student_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, subject_id),
    CONSTRAINT FK_STUDENT3 FOREIGN KEY (student_id) REFERENCES STUDENT3 (student_id),
    CONSTRAINT FK_SUBJECT3 FOREIGN KEY (subject_id) REFERENCES SUBJECT3 (subject_id)
);