import model.*;
import repository.BookRepository;
import service.BookService;
import exception.InvalidInputException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        Category science = new Category(2, "Science");
        BookBase ebook = new EBook(0, "Java Programming", science, 15.5);

        System.out.println("--- Starting API Demonstration ---");

        try {
            service.addBook(ebook, 45.0);
            System.out.println("\nCurrent books in database:");
            service.listAllBooks();
            System.out.println("\nTesting validation with negative price:");
            service.addBook(new EBook(0, "Error Book", science, 1.0), -1.0);

        } catch (InvalidInputException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
        ebook.displayInfo();
    }
}