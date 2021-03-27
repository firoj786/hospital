# hospital
# First you need to install PostgreSQL database
# Then import this application using Maven
# After that you need to change username and password in application.properties
# Then run application and open swagger ui http://localhost:8080/swagger-ui.html
# You can run test cases for test service implementation methods.

Java Technical Assignment
Instructions​ :
● Submission process: Send us the repository url where the code is
stored to complete the submission of your work.
● Completion time: Sunday midnight.

Task​ :
We have a platform where doctors can register their patients through a mobile or web portal. For this
to work we need to build backend APIs to achieve task like:
● Adding a patient record
● Updating an existing patient record
● Deleting a patient record
● Fetching all the patient records in an order.

Patient records should contain the following with validation at the backend:
1. Name ( ​ should be at least 3 characters)
2. Address ( ​ should be at least 10 characters)
3. Email ( ​ should be a valid email address)
4. Phone number​ (should be at least 10 number + country code)
5. Password ​ (must contain one upper character, one lower character and a number. Max length
15 and min length 8)
Now there would be another API as well on top of all the above, which schedules an appointment for
a patient. Hence the list which fetches all the patient records should be displayed in date ascending
order.

How do you need to achieve this task?
● You need to use ​ Spring Boot Framework for core functionalities along with ​ Hibernate for
carrying out database operations.
● Following points will be considered as ​ plus points​ if you incorporate these (optional):
○ Use Swagger to list all your APIs
○ Use Unit tests for API using JUNIT, or Mockito
○ Using user token authentication for API access
■ Maven build/deploy/test scripts
■ Maven library configurations
○ Use logging through Log4j 2.x​ http://logging.apache.org/log4j/1.2/
● Use any version control repository manager to store the code (like​ Github​,​ Gitlab​ etc).

Things to submit:
● README page in the repository containing code with information like:
○ List of all the major libraries/frameworks used (and specific reason to use them).
○ List of all the p
lus points​ explaining whether or not you have worked on it and if yes,
explaining what and how of all the features you have added.
○ How to run tests (if incorporated)
○ How to deploy the project.



○ You can use Maven build type to create your project
