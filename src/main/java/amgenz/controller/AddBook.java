package amgenz.controller;

import amgenz.entity.Author;
import amgenz.entity.Book;
import amgenz.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to add a book to the database.
 * @author amgenz
 */

@WebServlet(
        urlPatterns = {"/addBook"}
)

public class AddBook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("submit").equals("addBook")) {
            String bookTitle = req.getParameter("bookTitle");
            String summary = req.getParameter("summary");
            String genre = req.getParameter("genre");
            int series = Integer.parseInt(req.getParameter("series"));
            String authorFirstName = req.getParameter("authorFirstName");
            String authorMiddleName = req.getParameter("authorMiddleName");
            String authorLastName = req.getParameter("authorLastName");
            String authorAbout = req.getParameter("authorAbout");


            addBook(bookTitle, summary, genre, series, authorFirstName, authorMiddleName, authorLastName, authorAbout);
            logger.info("Added the new recipe to the database");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/addConfirmation.jsp");
            dispatcher.forward(req, resp);
        }

    }

    public static void addBook(String bookTitle, String summary, String genre, int series, String authorFirstName,
                               String authorMiddleName, String authorLastName, String authorAbout) {
        GenericDao bookDao = new GenericDao(Book.class);
        GenericDao authorDao = new GenericDao(Author.class);

        List<Author>  authors = authorDao.getByPropertyEqual("lastName", authorLastName);
        Author author = authors.get(0);
        if (author == null) {
            Author newAuthor = new Author(authorFirstName, authorMiddleName, authorLastName, authorAbout);
            int id = authorDao.insert(newAuthor);
            Author insertedAuthor = (Author) authorDao.getById(id);
            Book newBook = new Book(bookTitle, summary, null, genre, series, insertedAuthor);
            bookDao.insert(newBook);
        } else {
            Book addedBook = new Book(bookTitle, summary, null, genre, series, author);
            bookDao.insert(addedBook);
        }

    }
}