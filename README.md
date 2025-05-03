# JavaEE Backend API

This is a secure RESTful backend API built with Spring Boot. It includes JWT-based authentication, role-based access control, and modular architecture to support user management and weather data APIs.

## Features

- User registration and login
- JWT authentication and token refresh
- Role-based access control (Admin, User)
- Secure endpoints with Spring Security
- REST APIs for managing users and fetching weather data

## Tech Stack

- Java 11
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Hibernate & JPA
- Maven

## Project Structure

```
src/
├── main/
│   ├── java/com/gupta/backend/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── data/
│   │   ├── repository/
│   │   ├── service/
│   │   └── JavaEeProjectApplication.java
│   └── resources/
│       └── application.properties
```

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Gupta2501/javaee-backend.git
   ```

2. Configure your database in `application.properties`

3. Build and run:
   ```bash
   ./mvnw spring-boot:run
   ```

4. API available at `http://localhost:8080`
