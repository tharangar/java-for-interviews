
# H2 DATABASE
H2 is one of the popular in memory databases. Spring Boot has very good integration for H2.
https://www.springboottutorial.com/spring-boot-and-h2-in-memory-database

Above web site has more descriptive lesson regarding H2 with screen shots.


H2 supports a sub set of the SQL standard.

H2 also provides a web console to maintain the database.


Scenario 1 - Let’s consider a situation where you would want to do a quick POC. Using a traditional database involves a lot of overhead.

Scenario 2 - Consider your unit tests

    You don’t want them to fail when some data/schema in the database changes
    You would want to be able to run them in parallel - multiple developers might be running the tests in parallel.

In these kind of scenarios, an in memory database provides an ideal solution.

An in memory database is created when an application starts up and destroyed when the application is stopped.

But if we want persistent upto some extends you may file based h2 db which you may hold data .


### Advantages.

Advantages

   * Zero project setup or infrastructure
   * Zero Configuration
   * Zero Maintainance
   * Easy to use for Learning, POCs and Unit Tests
   * Spring Boot provides Simple Configuration to switch between a real database and an in memory database like H2



You need very little configuration to connect Spring Boot application with H2.

In most situations, just adding the H2 runtime jar into dependencies should be sufficient.

```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

## Start a project with H2.

Spring Initializr http://start.spring.io/ is great tool to bootstrap your Spring Boot projects.

    Launch Spring Initializr and choose the following
        Choose com.in28minutes.springboot.rest.example as Group
        Choose spring-boot-2-jpa-with-hibernate-and-h2 as Artifact
        Choose following dependencies
            Web
            JPA
            H2
            DevTools
    Click Generate Project.
    Import the project into Eclipse. File -> Import -> Existing Maven Project.

Create a simple Student Entity with a primary key id.

```
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String passportNumber;

```

## H2 Console

H2 provides a web interface called H2 Console to see the data. Let’s enable h2 console in the application.properties.

/src/main/resources/application.properties

```
# Enabling H2 Console
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default

```
When you reload the application, you can launch up H2 Console at http://localhost:8080/h2-console.

You have to provide same url you provided in the property file to the colsole as well.

## Running a sql script while applicaiton statup.

Its because of Spring Boot Auto Configuration. We will talk about this in the next section.

You can also populate some data into student table by adding a file called data.sql

/src/main/resources/data.sql

```
insert into student
values(10001,'Ranga', 'E1234567');

insert into student
values(10002,'Ravi', 'A1234568');
```

## Running H2 as a persisted database with Spring Boot.

While we dont recommend this , it interesting to note that H2 has a persisted database mode

    With this configuration, the data is not lost even after spring boot restart and computer restart.

You would find H2 being very rarely used in this way. If you are really interested in a persistent database, we recommend exploring MySQL, Oracle or some other relational database.

application.properties

```
spring.datasource.name=yourdbname
spring.datasource.driverClassName=org.h2.Driver
 
spring.datasource.initialize=false
spring.datasource.url=jdbc:h2:file:~/yourdbname;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;
 
spring.jpa.hibernate.ddl-auto = update

```

## Unit Testing with H2.

If we want to use different properties for tests, then we can override the properties file in the main folder by placing another file with the same name in src/test/resources.

The application.properties file in src/test/resources folder should contain the standard key-value pairs necessary for configuring a in memory connection.

First add the dependencies for your database driver (mysql in the example below) and make the dependency for h2 test scoped.

```
dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>
```

Use the mysql database for your real code

src\main\resources\application.properties

```
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/person_example
spring.datasource.username=personuser
spring.datasource.password=YOUR_PASSWORD
```

Use in memory database for your unit tests

src\test\resources\application.properties

```
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
spring.datasource.username=sa
spring.datasource.password=sa
```

