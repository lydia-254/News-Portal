#Project
News Portal.

## Author
KANG'ERI LYDIA WANGARE.

## Description
It is a rest REST API application for querying and retrieving scoped news and information.


## Project setup instructions
* Make sure you have all the Requirements of running Java apps installed such as JUnit, intellij, SDK, JDK.

* Clone the project into your machine from https://github.com/lydia-254/News-Portal.git

* Gradle run javac News Portal.java to compile and java news portal to run the program.

​
# Server Side
​
The application has three model classes;
​
- Departments
- Employee
- News

The API routes;
​
- GET "/employee"
- GET "/departments"
- GET "/employee/:id"
- GET "/departments/:id"
- GET "/departments/:id/employee"
- GET "/departments/:id/news"
- GET "/news"
- GET "/news/general"
- GET "/news/department"
​
- POST "/Employee/new"
- POST "/Departments/new"
- POST "/News/new"
- POST "/DepartmentNews/new"
​
## Set up
CREATE DATABASE news_portal;
\c news_portal;
CREATE TABLE departments(id serial PRIMARY KEY, name VARCHAR, num_members INTEGER);
CREATE TABLE
news_portal=# CREATE TABLE news( id serial PRIMARY KEY, content VARCHAR, employeeId INTEGER, DepartmentId INTEGER);
CREATE TABLE
news_portal=# CREATE TABLE employee(  id serial PRIMARY KEY, name VARCHAR, position VARCHAR, role VARCHAR, DepartmentId INTEGER);
CREATE TABLE
news_portal=# CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;


## Technologies used
* JAVA
* GRADLE (for unit testing)
* BOOTSTRAP
* SPARK
* HTML
* POSTGRES
* Sql2o
* GIT VCS

## Live Site

You can view this by following up this link( )

### License

The project is under[MIT license]
Copyright &copy; 2021.All right reserved.

## Support and contact details

contact me kangerilydia@gmail.com
Tel +254719781523.
Tel +254795491486.
