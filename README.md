![Kainos theme](https://media-exp1.licdn.com/dms/image/C4D1BAQHfy4m6WUUiLQ/company-background_10000/0/1625482557141?e=2159024400&v=beta&t=m0Swo1L3x5U84YO7IzNfL4lIb3nQqLFV5-iBzU1YkFs)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Testing](#testing)
* [Contributors](#contributors)

## General info
API side of an online job application serving both Kainos 
employees and recruitment admin to retrieve and update 
job roles and their relevant information

## Technologies
Project is created with
- Java 16.0.1
- Maven 3.8.2
- Spring Boot 2.5.4

## Setup
To run this project
- Clone repository
- In `src/main` directory, create `application.properties` file containing

* Database Connection Properties:
```
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://[databaseHost]/[databaseName]
spring.datasource.username=[databaseUsername]
spring.datasource.password=[databasePassword]
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.sql.init.continue-on-error=true
```
* Logging Properties:
```
logging.level.com.team404.kainosproject.service=INFO
logging.level.com.team404=ERROR
logging.file.name=./logs/server.log
```
- From the root of project repository execute
```
$ mvn spring-boot:run
```

- The application will run on port 8080 on 
 localhost address
  - http://localhost:8080/
- Check controllers in package `com.team404.kainosproject.controller` 
  to see available mappings with HTTP methods

## Testing
To run the tests, execute
```
$ mvn test -Dtest=con.team404.kainosproject.**.*
```

## Contributors

- [@SamuelChorvat](https://github.com/SamuelChorvat)
- [@Jackrwal](https://github.com/Jackrwal)
- [@AngelShayeReyes](https://github.com/AngelShayeReyes)
- [@PriyankaJ-K](https://github.com/PriyankaJ-K)
- [@Chottek](https://github.com/Chottek)



