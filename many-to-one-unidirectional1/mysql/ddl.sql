/***************************/
/*Many To One Unidirectional*/
/***************************/
/*Drop the table*/
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists STUDENT1;
drop table if exists UNIVERSITY1;

create table UNIVERSITY1 (
   university_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY (university_id)
);
 
create table STUDENT1 (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   university_id BIGINT NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id),
   CONSTRAINT student_university FOREIGN KEY (university_id) REFERENCES UNIVERSITY1 (university_id) ON UPDATE CASCADE ON DELETE CASCADE
);