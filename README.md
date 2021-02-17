# RobertRice_OdinsStudy_CaseStudy
Project I designed for Per Scholas case study.

Instructions for project were as follows:
A Java web application created using Spring MVC or Spring Boot
Name the application: FirstnameLastname_ProjectName_CaseStudy
When completed, place the project, database schema and any optional files in a folder named FirstnameLastname_ProjectName_CaseStudy and compress the folder and upload it to Canvas
Use Tomcat as the web server
Views:
Your app should include 6 different views/pages. Pages should all be relevant to the application and flow well from one page to the next.
Implement HTML/CSS/JavaScript to create the view templates
Utilize external files to manage CSS and JavaScript
Implement Thymeleaf or JSP to make the views/pages dynamic
Include a navigation section that is included across multiple pages
You may substitute an alternative front-end framework such as Angular or React in place of HTML, JSP or Thymeleaf, but this will not be covered or supported through the class. The same applies to styling frameworks such as Bootstrap. The presentation of the application must meet the general view requirements that are outlined above.
Models and Database:
Use MariaDB or MySQL
Have at least four models along with tables in a relational database (if four models/tables do not make sense for your application, discuss this with your instructor)
Include a schema diagram of the tables (there are tools online to assist with this)
Each model should have an associated repository/service class/interface to manage interaction with the database
You should use Jakarta Persistence API (JPA) and Spring Data JPA to manage the database operations in your application
Models should be annotated for binding and validation using Spring data binding along with Jakarta and Hibernate validation
You may use front end validation using HTML or JavaScript, but this does not substitute for back end validation of the models
Your application should include at least one example of each of the CRUD operations
The project should include at least three custom queries based on method name and/or SQL/JPQL
Use JUnit to perform unit and/or integration tests on the three custom query methods
Spring Application
Include sign up (registration) and login functionality (authentication)
Utilize some form of encryption to store passwords (e.g., bcrypt)
Utilize one form of session management
The project package structure should be as shown in class where the models, dao, service, controllers, exceptions, etc. each have a package. Views or templates don’t require a package.
Standard Java naming conventions should be followed:
Classed should be written in Pascal case
Variables, methods and URLs should be written in camel case
Files, including view files, should be written in snake case
Packages should be in all lowercase with each section separated by dots (.) (e.g., org.perscholas.myapp.models)
Packages should include the name of your project and your name (e.g., “org.johndoe.myprojectname”)
Each class, method and view should include comments (e.g., Javadoc)  to describe the class or method
Custom exceptions - make at least one custom exception
