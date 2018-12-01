drop table IF EXISTS PermanentEmployee;
drop table IF EXISTS ContractEmployee;
drop table IF EXISTS Employee;


create table Employee (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) ,
   PRIMARY KEY (id)
);

create table ContractEmployee (
   id BIGINT NOT NULL ,
   salary FLOAT(7,3),
   PRIMARY KEY (id),
   CONSTRAINT FK_ContractEmployee FOREIGN KEY (id) REFERENCES Employee (id)
);

create table PermanentEmployee (
   id BIGINT NOT NULL ,
   salary FLOAT(7,3),
   PRIMARY KEY (id),
   CONSTRAINT FK_PermanentEmployee FOREIGN KEY (id) REFERENCES Employee (id)
);
