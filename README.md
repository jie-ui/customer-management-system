# Customer Management System

A full-stack web application built with **Spring Boot, Thymeleaf, JPA, and MySQL** for managing customer records.
This project demonstrates a layered architecture, CRUD operations, validation, and unit testing.

---

## Features

- Create, update, delete, and view customer records
- Server-side validation for input data
- Sorted customer listing (by last name)
- Clean MVC architecture (Controller → Service → Repository → Entity)
- Logging with Spring AOP
- Unit testing with JUnit 5 and Mockito

---

## Tech Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- JUnit 5 & Mockito
- Maven

---

## Project Structure

    src/
    ├── controller
    ├── service
    ├── dao (repository)
    ├── entity
    ├── aspect
    └── resources/templates

---

## Setup & Run

### 1. Clone the repository

    git clone https://github.com/jie-ui/customer-management-system.git
    cd customer-management-system

### 2. Configure database

Update `application.properties`:

    spring.datasource.url=jdbc:mysql://localhost:3306/customer_management
    spring.datasource.username=YOUR_USERNAME
    spring.datasource.password=YOUR_PASSWORD

### 3. Run the application

    ./mvnw spring-boot:run

Or run `CustomerManagementApplication` in IntelliJ.

### 4. Access the application

Open in browser: `http://localhost:8080/customers/list`

### 5. Run tests

    ./mvnw test

Unit tests were implemented using JUnit 5 and Mockito.

---

## Key Highlights

- Implemented layered architecture for scalability and maintainability
- Used Spring Data JPA to simplify database interactions
- Applied AOP for centralized logging
- Designed testable service layer using dependency injection
- Covered core business logic with unit tests

---

## Author

Jie Yang
