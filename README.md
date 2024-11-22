Webflux API Study Project
==========================

This project is a study on building a RESTful API using Spring Webflux. It aims to demonstrate the use of reactive
programming principles.

## Technologies and Resources

* **Spring Webflux**: A reactive web framework for building scalable and high-performance web applications.
* **Gradle**: A build automation tool for managing dependencies, compiling, and packaging the project.
* **Java 17**: The programming language used for developing the project.
* **MongoDB Reactive**: A reactive MongoDB driver for interacting with the database.
* **Lombok**: A library for reducing boilerplate code and improving developer productivity.
* **Mapstruct**: A library for mapping between Java beans and DTOs.

## Project Structure

The project is structured into the following modules:

* **src/main/java**: Contains the Java source code for the project, including the API controllers, services, and
  entities.
* **controller**: Contains the REST controllers for handling HTTP requests.
* **entity**: Contains the data entity for the API, including the `User` class.
* **mapper**: Contains the mapper classes for the User entity and request.
* **repository**: Contains the class for interacting with the database.
* **service**: Contains the service classes for the project.
* **validator**: Contains the annotation interface to validate requests inputs.

## API Endpoints

The project provides the following API endpoints:

* **POST /users**: Creates a new user.
* **GET /users**: Retrieves a list of all users.
* **GET /users/{id}**: Retrieves a user by ID.
* **PUT /users/{id}**: Updates a user by ID.
* **DELETE /users/{id}**: Deletes a user by ID.

## Running the Project

To run the project, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory and run `docker compose up -d` to start MongoDB local instance.
3. Run `gradle bootRun` to start the application.
4. Use a tool like Postman or cURL to test the API endpoints.