
# Reward Service - Spring Boot

## Tech Stack
- Java 17
- Spring Boot 3
- Maven
- JUnit 5

## Business Logic

Reward calculation:
- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100

Example:
- Purchase of $120
- 2 * 20 + 1 * 50 = 90 points

## REST Endpoints

### Get all customer rewards
GET /api/rewards

### Get reward by customer id
GET /api/rewards/{customerId}

## Run Application

mvn spring-boot:run

## Run Tests

mvn test

## Features Included
- RESTful API
- Dynamic month calculation
- Multiple customers and transactions
- Unit tests
- Integration tests
- Exception handling
- JavaDocs-ready clean structure
- Java 17 compatible
