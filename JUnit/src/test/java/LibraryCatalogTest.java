import org.example.book.Book;
import org.example.book.LibraryCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {
    private LibraryCatalog libraryCatalog;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        libraryCatalog = new LibraryCatalog();
        book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    }

    @Test
    void addBook_BookAddedSuccessfully() {
        libraryCatalog.addBook(book1);
        List<Book> books = libraryCatalog.getBooks();

        assertEquals(1, books.size());
        assertTrue(books.contains(book1));
    }

    @Test
    void borrowBook_BookAvailable_BorrowSuccessful() {
        libraryCatalog.addBook(book1);
        libraryCatalog.borrowBook("The Great Gatsby");

        assertFalse(book1.isAvailable());
    }

    @Test
    void returnBook_BookReturnedSuccessfully() {
        libraryCatalog.addBook(book1);
        book1.setAvailable(false); // Marking the book as not available manually
        libraryCatalog.returnBook("The Great Gatsby");

        assertTrue(book1.isAvailable());
    }

    @Test
    void returnBook_BookNotBorrowed_ReturnUnsuccessful() {
        libraryCatalog.addBook(book1);
        libraryCatalog.returnBook("The Great Gatsby");

        assertTrue(book1.isAvailable());
    }
}
