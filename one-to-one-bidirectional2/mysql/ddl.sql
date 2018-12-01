/*Drop the table*/
drop table IF EXISTS address;
drop table IF EXISTS customer;


CREATE TABLE IF NOT EXISTS customer (
  customerId int(11) NOT NULL AUTO_INCREMENT,
  firstName varchar(255) DEFAULT NULL,
  PRIMARY KEY (customerId)
) ;

/*Create the required tables*/
CREATE TABLE IF NOT EXISTS address (
  addressId int(11) NOT NULL AUTO_INCREMENT,
  city varchar(255) DEFAULT NULL,
  customerId int(11) NOT NULL,
  PRIMARY KEY (addressId),
  FOREIGN KEY (customerId) REFERENCES customer (customerId)
) ;


/*Select the created table*/
select * from customer;
select * from address;
