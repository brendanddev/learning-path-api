# SpringDock (Previously Learning Path API)

SpringDock is a Dockerized Spring Boot application for managing users and skills.  
It demonstrates REST API development, database integration, and containerization with Docker and Docker Compose.

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
│  ├─ Dockerfile
│  └─ docker-compose.yml
├─ src/
│  ├─ main/
│  │  ├─ java/com/brendan/springdock/
│  │  │  ├─ controllers/
│  │  │  ├─ models/
│  │  │  ├─ repository/
│  │  │  └─ services/
│  │  └─ resources/
│  │     └─ application.properties
│  └─ test/
├─ target/
├─ pom.xml
├─ mvnw
├─ mvnw.cmd
├─ LICENSE
└─ README.md
```

---