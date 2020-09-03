CREATE DATABASE billingDB;
create table billingDB.school(
school_id int NOT NULL AUTO_INCREMENT primary key,
school_type  enum('Private','Public') NOT NULL ,
School_name  varchar(100) 
);
CREATE table billingDB.student(
student_id int NOT NULL AUTO_INCREMENT primary key,
first_name varchar(50) ,
last_name varchar(50) ,
student_tele_number int(10),
email varchar(60) NOT NULL ,
password nvarchar(100)NOT NULL ,
gender enum('M', 'F') ,
date_of_birth date,
school_id int,
FOREIGN KEY (school_id) REFERENCES school(school_id)
);
create table billingDB.tuition_plan(
tuition_plan_id  int NOT NULL AUTO_INCREMENT primary key,
tuition_plan_name varchar(50) NOT NULL,
school_id int,
FOREIGN KEY (school_id) REFERENCES school(school_id)
);
create table billingDB.payment(
payment_id int NOT NULL AUTO_INCREMENT primary key,
payment_datetime date ,
payment decimal(15,2),
student_id int,
tuition_plan_id  int,
student_email varchar(50),
FOREIGN KEY (student_id) REFERENCES student(student_id),
FOREIGN KEY (tuition_plan_id) REFERENCES tuition_plan(tuition_plan_id)
);
INSERT INTO billingDB.school (school_type,School_name) values ("Public","School 1");
INSERT INTO billingDB.student (first_name, last_name, student_tele_number, email,password,gender,date_of_birth,school_id) VALUES ("Ann",
   "perera",
   1324423453,
   "test@gmail.com",
   "test",
   "F",
    "2012-12-01",1); 
INSERT INTO billingDB.tuition_plan (tuition_plan_name,school_id) VALUES ("plan 1",1);   
INSERT INTO billingDB.payment (payment_datetime,payment,student_id,tuition_plan_id,student_email) VALUES ("2020-09-03",56.00,1,1,"test@gmail.com");   
    