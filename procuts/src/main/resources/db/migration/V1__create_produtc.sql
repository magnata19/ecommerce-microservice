CREATE TABLE products(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  stock int NOT NULL,
  description varchar(255) NOT NULL,
  PRIMARY KEY (id)
);