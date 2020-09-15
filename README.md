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

The application can be run on `localhost:8080`.

I've set up Swagger UI to make it easier to consume the endpoints in the application. It can be accessed by navigating to `http://localhost:8080/swagger-ui.html`

# Developer Notes
I've set up the application in an n-tiered approach, taking full advantage of the Spring Framework's DI capabilities. 
The database is an in memory database currently, but it's extremely easy to swap it out for another one, and I plan on experimenting with MongoDB next.

I also want to add some docker containerization and orchestration to it to make setting up the dev environment and potential dependencies easier.

# Limitations
1. Like I mentioned above, this is using an in memory database to persist character data. With that said, it's extremely simple using the power of DI to set up a specific database implementation and use that instead.
1. Loot Generation is...bare bones. The array of possible items is hardcoded in memory as well, and it's a relatively small list.
1. Each item you randomly loot will generate an item with a random name and modifier attached to it. The rarity of the item (also random) will determine the "strength" of the modifier. More rare items will have better modifiers.
  1. The system is set up to allow for the addition of many different modifier types, but currently there are only two.
  1. Right now each item will only have one modifier attached. I expect it would be cool if certain rarities of items could have more modifiers (like in Diablo).
1. Hit Points is currently incomplete. The intention was to compute a character's available hit points based on the gear they are wearing. The modifiers would influence that number. So the work is started, it's just not finished yet. One day...
1. This is just an API. It's intended to be consumed by an SPA or possibly a game of some type.
