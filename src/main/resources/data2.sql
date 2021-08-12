drop database login_app;
create database login_app;
use login_app;
show tables;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(256) NOT NULL,
  PRIMARY KEY (id)
);
  
CREATE TABLE role 
(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE user_role(
user_id int,
role_id int,
FOREIGN KEY (user_id)
REFERENCES user(id),
FOREIGN KEY (role_id)
REFERENCES role(id)
);