/***************************/
/*One To Many Bidirectional*/
/***************************/
/*Drop the table*/
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists subject;
drop table if exists student;

CREATE TABLE  student (
    studentId BIGINT(20) NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL ,
    PRIMARY KEY (studentId)
);

CREATE TABLE subject (
    subjectId BIGINT(10) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NULL DEFAULT NULL,
    studentId BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (subjectId),
    FOREIGN KEY (studentId) REFERENCES student(studentId)
);

select * from student;
select * from subject;

/* Get all the subjects of where student id is 2*/
select st.firstName , sb.name from student st, subject sb where st.studentId = 2 and st.studentId = sb.studentId;

/*Get all student name and their subjects */
select st.firstName , sb.name from student st, subject sb where st.studentId = sb.studentId;

/* Get all the subjects of sam*/
select st.firstName , sb.name from student st, subject sb where st.firstName = 'Sam' and st.studentId = sb.studentId;