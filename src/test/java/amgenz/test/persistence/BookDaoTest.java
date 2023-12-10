package amgenz.test.persistence;

import amgenz.entity.Author;
import amgenz.entity.Book;
import amgenz.persistence.GenericDao;
import amgenz.test.util.Database;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type book dao test.
 */
class BookDaoTest {
    GenericDao dao;
    GenericDao daoAuthor;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao(Book.class);
        daoAuthor = new GenericDao(Author.class);
    }

    /**
     * Verifies gets all book's success.
     */
    @Test
    void getAllBooksSuccess() {
        List<Book> book = dao.getAll();
        assertEquals(4, book.size());
    }

    /**
     * Verifies a book is returned correctly based on id search.
    */
    @Test
    void getByIdSuccess() {
        Book retrievedBook = (Book) dao.getById(4);
        assertNotNull(retrievedBook);
        assertEquals("It Ends With Us ", retrievedBook.getTitle());
    }

    /**
     * Verify successful insert of a book
     */
    @Test
    void insertSuccess() {
        Book newBook = new Book("Verity", "A really good romance book", "Romance", 0, null);
        int id = dao.insert(newBook);
        assertNotEquals(0,id);
        Book insertedBook = (Book) dao.getById(id);
        assertEquals(newBook,insertedBook);
    }

    /**
     * Verify successful delete of book
    */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }

    /**
     * Verify Update success for an book.
     */
    @Test
    void updateSuccess() {
        String genre = "Crime";
        Book updateBook = (Book) dao.getById(3);
        updateBook.setGenre(genre);
        dao.saveOrUpdate(updateBook);
        Book retrievedBook = (Book) dao.getById(3);
        assertEquals(updateBook, retrievedBook);
    }

    /**
     * Verify successful get by property (equal match)
    */
    @Test
    void getByPropertyEqualSuccess() {
        List<Book> book = dao.getByPropertyEqual("title", "The Housemaid");
        assertEquals(1, book.size());
        assertEquals(2, book.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
    */
    @Test
    void getByPropertyLikeSuccess() {
        List<Book> book = dao.getByPropertyLike("title", "It");
        assertEquals(2, book.size());
    }
}