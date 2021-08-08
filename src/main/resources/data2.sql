drop database login_app;
create database login_app;
use login_app;
show tables;

select * from user;
select * from role;
select * from user_role;

CREATE TABLE `login_app`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);
  
CREATE TABLE ROLE 
(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20),
PRIMARY KEY (ID)
);

CREATE TABLE USER_ROLE(
USER_ID int,
ROLE_ID int,
FOREIGN KEY (user_id)
REFERENCES user(id),
FOREIGN KEY (role_id)
REFERENCES role(id)
);

insert into user(id, username, name, password) values 
(10001, 'managers','mr manager','$2a$12$hpN4cl1r/9AuJLk74ctzh.f7shXwqPqJCQAqsdYfbaXjuNENAF.Xq');
insert into user(id, name, username, password) values  
(10002, 'useruser','mr user','$2a$12$qQCBLhv4YqjgCnSOu3fB2uJDrMvAG6sUXoxDGqEAgs/nsNHP6MByu');
insert into role values(1,'ROLE_MANAGER');
insert into role values(2,'ROLE_USER');

insert into user_role values(10001,1);
insert into user_role values(10002,2);

select * from user;
select * from role;
select * from user_role;
