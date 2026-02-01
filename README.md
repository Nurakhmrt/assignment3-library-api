# Assignment 3 & Assignment 4 – Library Management API (Java)

This project is an extended version of **Assignment 3**, updated to fully satisfy the requirements of **Assignment 4**.  
It demonstrates SOLID principles, advanced object-oriented programming concepts, and a clean layered architecture.

---

## Project Overview

A console-based Library Management System implemented in Java.  
The system manages books and categories, applies validation and exception handling, and persists data using JDBC and PostgreSQL.

---

## Architecture

The project follows a layered architecture:

- Controller layer (entry point via `Main`)
- Service layer (business logic and validation)
- Repository layer (JDBC-based data access)
- Database layer (PostgreSQL)

This structure ensures separation of concerns and maintainability.

---

## Assignment 4 Features

### SOLID Principles

- **Single Responsibility Principle (SRP)**  
  Responsibilities are separated across model, service, repository, and utility layers.

- **Open/Closed Principle (OCP)**  
  The abstract class `BookBase` is extended by multiple subclasses without modification.

- **Liskov Substitution Principle (LSP)**  
  Objects of type `EBook` and `PrintedBook` can be used interchangeably as `BookBase`.

- **Interface Segregation Principle (ISP)**  
  Interfaces `Printable` and `PricedItem` provide focused responsibilities.

- **Dependency Inversion Principle (DIP)**  
  `BookService` depends on repository interfaces instead of concrete implementations.

---

### Object-Oriented Programming

- **Abstract Class**  
  `BookBase` defines common properties and behavior for all books.

- **Inheritance**  
  `EBook` and `PrintedBook` extend `BookBase`.

- **Polymorphism**  
  Books are handled through `List<BookBase>` with runtime method dispatch.

- **Composition**  
  `BookBase` contains a `Category` object, demonstrating composition.

---

### Interfaces

- `Printable`  
  Contains a `default` method `print()` for standardized output.

- `PricedItem`  
  Contains a `static` method `isValidPrice()` for price validation.

---

### Generics

- A generic CRUD interface is implemented:
  ```java
  CrudRepository<T, ID>
BookRepository implements this interface, ensuring reusable and type-safe data access.

Lambda Expressions
Lambda expressions are used for sorting collections:

SortingUtils.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
Reflection (RTTI)
Reflection is demonstrated using ReflectionUtils.

The utility inspects objects at runtime and prints:

Class name

Declared fields

Declared methods

Exception Handling
All validation and business rules are handled in the service layer.

Custom exceptions used:

InvalidInputException

ResourceNotFoundException

DuplicateResourceException

DatabaseOperationException

How to Run
Configure PostgreSQL and create the required tables.

Update database credentials in DatabaseConnection.

Run Main.java to execute the application.

Notes
Assignment 4 is implemented on top of Assignment 3, not as a separate project.

The final implementation is available in the master branch of this repository.
