# health-insurance

The application can be able to do below things:
- Add a new enrollee
- Modify an existing enrollee
- Remove an enrollee entirely
- Add dependents to an enrollee
- Remove dependents from an enrollee
- Modify existing dependents

## Running the application
---run by main method Locally
run as java application on com.insurance.HealthInsuranceApplication

--Running the application with Maven
$ git clone https://github.com/neelshah248/Health-Insurance2.git
$ cd health-insurance
$ mvn spring-boot:run

--Running the application with Executable JAR
$ git clone https://github.com/neelshah248/Health-Insurance2.git
$ cd health-insurance
$ mvn package -DskipTests
$ java -jar target/health-insurance-0.0.1-SNAPSHOT.jar --spring.profiles.active=test

## Swagger url
-rest api documentation
http://localhost:8181/swagger-ui.html

