# Lab8


This laboratory work is devoted to the development of the first rest service using the Java language using the JAX-RS library.

1) Task 8 of the laboratory is to create a REST service for one of the classes created in laboratory work 2, which implements CRUD-operations (Get / Post / Put / Delete) on the resource (for example, on the resource Aligator) and the return operation of all objects.
2) The get operation must use the id in the url: / aligator / 20
3) The get without id operation in the url should return a list of all available objects
4) To implement the REST service, the base class from the 8th laboratory should be expanded with the id field (type Integer), and add set / get methods
5) Also the code should be checked due to Findbugs / checkstyle / pmd plugins
6) The code should be filled with a separate pool of requests relative to the code of the 7th laboratory (ie you need to create a separate brunch in the same repository where the code of the 7th work, which will later become a pool of requests, but the pool request does not move !!!!)
7) The controller code and the RestApplication class must be placed in separate packages
8) Saving Alligator objects should be done in a Map object
9) This lab also involves modifying an existing pom.xml file by adding the necessary dependencies to it.
10) Implement the preservation of the object of one of the classes of laboratory work №2 in a table in the database using Spring boot and Spring data. Important: you need to understand how to save the child class and save both parent and child class data. Thus, the child-child class from the 2nd work must have additional attributes
- Data was stored and read using a database
- The code must match the code convention
- The code should be checked by plug-ins and bug fixes
- The code must be populated into the repository as a separate pull request (not a separate folder or separate repository)
- The code must contain a separate class * Controller, * Service and * Repository interface
- Configuring access to the database must be implemented through a corrupted file
