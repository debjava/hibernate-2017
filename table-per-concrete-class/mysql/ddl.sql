drop table IF EXISTS Employee;
drop table IF EXISTS ContractEmployee;
drop table IF EXISTS PermanentEmployee;

create table Employee (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) ,
   PRIMARY KEY (id)
);

create table ContractEmployee (
   id BIGINT NOT NULL ,
   name VARCHAR(30) ,
   salary FLOAT(7,3),
   PRIMARY KEY (id)
);

create table PermanentEmployee (
   id BIGINT NOT NULL ,
   name VARCHAR(30) ,
   projectname VARCHAR(30) ,
   PRIMARY KEY (id)
);
