# Task Data Transfer

### Used in project

- Java 17
- Maven
- Spring Boot

## Installation

1. Clone the repository.
2. Navigate to the project directory: `cd task-data-transfer`
3. Build the project: `./mvnw clean install`

## Usage

1. Start the application:

```bash
./mvnw spring-boot:run
```

2. Access the RESTful API: `GET http://localhost:8080/v1/coordinates/{countryCode}`, where `countryCode` is ISO 3166-1
   alpha-2 code.

## Tests

Run tests using the following command:

```bash
./mvnw test
```
