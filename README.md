# spring-boot-crud-demo
This repository contains a demo Spring Boot application demonstrating basic CRUD (Create, Read, Update, Delete) operations with a RESTful API. 

- **User Entity**: Represents a user with attributes such as name, email, gender, phone number, age, qualification, and occupation.
- **CRUD Operations**: API endpoints to create, read, update, and delete users.
- **Exception Handling**: Global exception handling using `@ControllerAdvice` for custom and built-in exceptions.

## Features

1. **Create User**: Add a new user to the database.
2. **Read Users**: Retrieve all users or a specific user by ID.
3. **Update User**: Update the details of an existing user.
4. **Delete User**: Remove a user from the database.

## Endpoints

- `POST /api/saveUser`: Create a new user.
- `GET /api/getUserById/{id}`: Retrieve a user by ID.
- `GET /api/getAllUsers`: Retrieve all users.
- `PUT /api/updateUserDetails/{id}`: Update a user by ID.
- `DELETE /api/deleteUserById/{id}`: Delete a user by ID.

## Technologies Used

- **Spring Boot**: Framework for building Java-based applications.
- **Spring Data JPA**: Provides repository support for accessing relational databases.
- **Hibernate**: ORM tool for database interactions.
- **MySQL Database**: Relational database management system.
