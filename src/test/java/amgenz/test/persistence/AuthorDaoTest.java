package amgenz.test.persistence;

import amgenz.entity.Author;
import amgenz.entity.Book;
import amgenz.persistence.GenericDao;
import amgenz.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type book dao test.
 */
class AuthorDaoTest {
    GenericDao dao;
    GenericDao daoBook;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao(Author.class);
        daoBook = new GenericDao(Book.class);
    }

    /**
     * Verifies gets all author's success.
     */
    @Test
    void getAllAuthorsSuccess() {
        List<Author> author = dao.getAll();
        assertEquals(2, author.size());
    }

    /**
     * Verifies an author is returned correctly based on id search.
     */
    @Test
    void getByIdSuccess() {
        Author retrievedAuthor = (Author) dao.getById(1);
        assertNotNull(retrievedAuthor);
        assertEquals("Colleen ", retrievedAuthor.getFirstName());
        assertEquals("Hoover", retrievedAuthor.getLastName());
    }

    /**
     * Verify successful insert of an author
     */
    @Test
    void insertSuccess() {
        Author newAuthor = new Author("Emily", null, "Henry", "Emily is a really great author.");
        int id = dao.insert(newAuthor);
        assertNotEquals(0,id);
        Author insertedAuthor = (Author) dao.getById(id);
        assertEquals(newAuthor, insertedAuthor);
    }

    /**
     * Verify successful delete of author
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify Update success for an author.
     */
    @Test
    void updateSuccess() {
        String middleName = "Marie";
        Author updateAuthor = (Author) dao.getById(1);
        updateAuthor.setMiddleName(middleName);
        dao.saveOrUpdate(updateAuthor);
        Author retrievedAuthor = (Author) dao.getById(1);
        assertEquals(updateAuthor, retrievedAuthor);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Author> author = dao.getByPropertyEqual("lastName", "McFadden");
        assertEquals(1, author.size());
        assertEquals(2, author.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Author> author = dao.getByPropertyLike("firstName", "e");
        assertEquals(2, author.size());
    }
}