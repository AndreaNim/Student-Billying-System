# Student Tuition Billing System
*The goal of this repository is to create a student tuition billing system.*

![ER Diagram](ER_Diagram.jpg)

Getting Started
-----
Requirements

1.Maven 3.0+

2.IDE(Eclipse or IntelliJ)

3.JDK 11

4.spring boot 2.3.3


**Step 1: Create database**

- Create the Databse tables using [Database script](https://github.com/AndreaNim/Student-Billying-System/tree/master/DB%20scripts) in MySQL database server.

- The script will add one record for each table.Manually add records to the tables.

    ```
    //Inserting values to school table
    INSERT INTO billingDB.school (school_type,School_name) values ("Public","School 1");
    //Inserting values to student table
    //email:test@gmail.com
    //password:test
    INSERT INTO billingDB.student (first_name, last_name, student_tele_number, email,password,gender,date_of_birth,school_id) VALUES ("Ann",
    "perera",
    1324423453,
    "test@gmail.com",
    "$2a$10$oA774YNJ6nlp0irgcfXtee6SLYgvvWTI/0UIDYG/6q5ylJ1v/7Ybm",
    "F",
        "2012-12-01",1); 
    //Inserting values to tuition plan table
    INSERT INTO billingDB.tuition_plan (tuition_plan_name,school_id) VALUES ("plan 1",1);   
    //Inserting values to payment table
    INSERT INTO billingDB.payment (payment_datetime,payment,student_id,tuition_plan_id,student_email) VALUES ("2020-09-03",56.00,1,1,"test@gmail.com"); 
    ```

- Define connection properties in /src/main/resources/application.properties

**Step 2: Build and Run the Project**


- The app will start running at http://localhost:8080.
    ```
    mvn spring-boot:run
    ```
**Step 3: Run the client application in local web server**

- open up the terminal or command prompt
- navigate to the directory where the files
- run a local python server by running:

    ```
    python3 -m http.server 1234
    ```

- Go to http://localhost:1234/login.html in your browser