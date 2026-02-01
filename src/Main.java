import model.*;
import repository.BookRepository;
import service.BookService;
import exception.InvalidInputException;
import utils.SortingUtils;
import utils.ReflectionUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        Category science = new Category(3, "Science");

        BookBase ebook = new EBook(0, "Java Programming", science, 15.5);
        BookBase printed = new PrintedBook(0, "Clean Code", science, 464);

        try {
            service.addBook(ebook, 45.0);
            service.addBook(printed, 30.0);
            service.listAllBooks();
            service.addBook(new EBook(0, "Error Book", science, 1.0), -1.0);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<BookBase> books = List.of(ebook, printed);

        var sorted = SortingUtils.sort(
                books,
                (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle())
        );

        for (BookBase b : sorted) {
            b.displayInfo();
            b.print();
        }

        System.out.println(PricedItem.isValidPrice(45.0));

        ReflectionUtils.inspect(ebook);
    }
}
