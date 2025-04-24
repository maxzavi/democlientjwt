# Client JWT SCA Sample


This is a sample client for the SCA using JWT.
Using client RestClient to call apis.

## Prerequisites

- Java 17
- Maven
- Spring Boot 3

## Swagger

http://localhost:8080/swagger-ui/index.html

## Build and run

```bash
mvn clean install
java -jar target/democlientjwt-0.0.1-SNAPSHOT.jar
```

## Environment variables

Add file application.yml in src/main/resources folder:

```yaml
sca:
  url: http://sca-api-jwt.acme.com/
```