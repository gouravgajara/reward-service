
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

## API Endpoints
Get rewards for a customer
GET /api/rewards/{customerId}
Example:

http://localhost:8080/api/rewards/101

## Sample Response
{
  "customerId": 101,
  "customerName": "John",
  "monthlyRewards": [
    {
      "month": "May",
      "points": 250
    },
    {
      "month": "March",
      "points": 90
    },
    {
      "month": "April",
      "points": 25
    }
  ],
  "totalRewards": 365
} 

## Get rewards for all customers
GET /api/rewards

## Sample Response
[
  {
    "customerId": 101,
    "customerName": "John",
    "monthlyRewards": [
      {
        "month": "May",
        "points": 250
      },
      {
        "month": "March",
        "points": 90
      },
      {
        "month": "April",
        "points": 25
      }
    ],
    "totalRewards": 365
  },
  {
    "customerId": 102,
    "customerName": "Smith",
    "monthlyRewards": [
      {
        "month": "May",
        "points": 110
      },
      {
        "month": "March",
        "points": 0
      },
      {
        "month": "April",
        "points": 45
      }
    ],
    "totalRewards": 155
  },
  {
    "customerId": 103,
    "customerName": "David",
    "monthlyRewards": [
      {
        "month": "May",
        "points": 10
      },
      {
        "month": "March",
        "points": 150
      },
      {
        "month": "April",
        "points": 290
      }
    ],
    "totalRewards": 450
  }
]

## Error Case (Customer Not Found)
http://localhost:8080/api/rewards/501

## Error Response 
{"error":"Customer not found with id: 501"}

## Author 
Gourav Gajara
