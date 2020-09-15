# Video Game Character Manager
A Spring Boot Java Character Builder

An experiment with using Spring Framework and Spring Boot for Java

A simple API that allows for the creation and management of a party of characters as well as a random loot generator.
This application is extremely basic currently, but I plan to add more to it, and eventually create a consuming client to consume the API.

Dependencies:
Java 8 and Java SE 8u261
Apache Maven 3.6.3

1. Clone repository
1. Add the Maven bin directory to `PATH` variable
1. Ensure that your `JAVA_HOME` variable is set to the location of your JDK
1. Use your favorite Java IDE and run the application!

The application is hosted on `localhost:8080`.

I've set up Swagger UI to make it easier to consume the endpoints in the application. It can be accessed by navigating to `http://localhost:8080/swagger-ui.html`

#Developer Notes:
This is just a very basic Spring Boot application that I got running. I've set up the application in an n-tiered approach, taking full advantage of the Spring Framework's DI capabilities. 
The database is an in memory database currently, but it's extremely easy to swap it out for another one, and I plan on experimenting with MongoDB next.

I also want to add some docker containerization and orchestration to it to make setting up the dev environment and potential dependencies easily, but we'll dodge that bullet when we get to it.
