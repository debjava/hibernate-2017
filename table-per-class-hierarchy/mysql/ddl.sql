drop table IF EXISTS Employee;

create table Employee (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) ,
   type VARCHAR(30) NOT NULL,
   salary FLOAT(7,3),
   PRIMARY KEY (id)
);
