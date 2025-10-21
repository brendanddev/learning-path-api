# SpringDock (Previously Learning Path API)

SpringDock is a Dockerized Spring Boot application for managing users and skills.  
It demonstrates REST API development, database integration, and containerization with Docker and Docker Compose.  
The project follows clean architecture and best practices for exception handling, validation, and service-layer business logic.

---

## Features

- **User & Skill Management:** CRUD operations for users and skills.
- **Skill Assignment:** Add or remove multiple skills for a user.
- **REST API Design:** Follows standard HTTP verbs and status codes.
- **Global Exception Handling:**  
  - `ResourceNotFoundException` → HTTP 404  
  - `BadRequestException` → HTTP 400  
- **Validation:** Required fields are validated in the service layer to ensure data integrity.
- **Service Layer Logic:** All business rules reside in services; controllers are thin.
- **Containerized Setup:** Easily run the API with Docker and Docker Compose.

---

## Tech Stack

- Java 17+
- Maven
- Spring Boot 3.x
- PostgreSQL
- Docker & Docker Compose

---

## Project Structure

```
spring-dock/
├─ docker/
│ ├─ Dockerfile
│ └─ docker-compose.yml
├─ src/
│ ├─ main/
│ │ ├─ java/com/brendan/springdock/
│ │ │ ├─ controllers/
│ │ │ ├─ exceptions/
│ │ │ ├─ models/
│ │ │ ├─ repository/
│ │ │ └─ services/
│ │ └─ resources/
│ │ └─ application.properties
│ └─ test/
├─ target/
├─ pom.xml
├─ mvnw
├─ mvnw.cmd
├─ LICENSE
└─ README.md
```

---

## Getting Started

### Prerequisites
- Java 17+
- Maven
- Docker & Docker Compose
- PostgreSQL (or use the one defined in docker-compose)

### Setup & Run
1. Clone the repository:
```bash
git clone https://github.com/brendanddev/springdock.git
cd springdock
```

2. Build the project with Maven:
```bash
./mvnw clean package
```

3. Start Docker containers (API + PostgreSQL):
```bash
docker-compose up --build
```

---