drop database login_app;
create database login_app;
use login_app;

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

insert ignore into user(id, username, name, password) values 
(10001, 'managers','mr manager','$2a$12$hpN4cl1r/9AuJLk74ctzh.f7shXwqPqJCQAqsdYfbaXjuNENAF.Xq');
insert ignore into user(id, username, name, password) values  
(10002, 'useruser','mr user','$2a$12$qQCBLhv4YqjgCnSOu3fB2uJDrMvAG6sUXoxDGqEAgs/nsNHP6MByu');
insert ignore into role values(1,'ROLE_MANAGER');
insert ignore into role values(2,'ROLE_USER');
insert ignore into user_role values(10001,1);
insert ignore into user_role values(10002,2);