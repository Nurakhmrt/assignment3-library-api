package service;

import exception.*;
import model.BookBase;
import repository.BookRepository;
import java.sql.SQLException;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(BookBase book, double price) throws InvalidInputException {
        if (price <= 0) throw new InvalidInputException("Price must be positive");
        try {
            repository.create(book, price);
        } catch (SQLException e) {
            throw new RuntimeException("DB Error: " + e.getMessage());
        }
    }

    public void listAllBooks() {
        try {
            repository.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}