package repository;

import model.BookBase;
import utils.DatabaseConnection;
import java.sql.*;

public class BookRepository {

    public void create(BookBase book, double price) throws SQLException {
        String sql = "INSERT INTO books (title, price, category_id, book_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setDouble(2, price);
            stmt.setInt(3, book.getCategory().getId());
            stmt.setString(4, book.getBookType());
            stmt.executeUpdate();
        }
    }

    public void update(int id, String title, double price) throws SQLException {
        String sql = "UPDATE books SET title = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setDouble(2, price);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void getAll() throws SQLException {
        String sql = "SELECT b.id, b.title, b.price, c.name as cat_name FROM books b JOIN categories c ON b.category_id = c.id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Title: " + rs.getString("title") +
                        " | Price: " + rs.getDouble("price") + " | Category: " + rs.getString("cat_name"));
            }
        }
    }
}