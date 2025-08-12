# Learning Path API

A Spring Boot RESTful API to manage users, skills, and personalized learning paths.
Designed to help users track their skills, learning content, and progress with flexible CRUD operations and recommendation features.

---

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Tech Stack](#tech-stack)

---

## About

The Learning Path API provides a backend solution for managing users and their associated skills in a learning management context.
Users can create profiles, add skills, and track progress on various learning topics. This API supports flexible management of skills and users through RESTful endpoints.

The project is built using Spring Boot, with JPA/Hibernate for database ORM, and supports common operations such as create, read, update, and delete (CRUD) for both users and skills.

---

## Features

- CRUD operations for Users and Skills
- Many-to-many relationship between Users and Skills
- Add or remove skills from users dynamically
- RESTful API design with proper HTTP status codes
- Data validation and error handling
- Simple and extendable codebase for easy customization
- Sample bash script for API testing

---

## Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA with Hibernate
- H2 Database (in-memory for development) or any other relational DB
- Maven for build management
- RESTful API design principles
- Bash + curl for simple API testing

---
