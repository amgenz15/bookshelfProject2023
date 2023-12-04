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
 * A simple servlet to edit a book.
 * @author amgenz
 */

@WebServlet(
        urlPatterns = {"/editBook"}
)

public class EditBook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao bookDao = new GenericDao(Book.class);
        int bookId;

        if (req.getParameter("submit").equals("editBook")) {
            bookId = Integer.parseInt(req.getParameter("book"));
            Book book = (Book) bookDao.getById(bookId);
            req.setAttribute("bookId", book.getId());
            req.setAttribute("title", book.getTitle());
            req.setAttribute("series", book.getSeries());
            req.setAttribute("summary", book.getSummary());
            req.setAttribute("genre", book.getGenre());
            Author author = book.getAuthor();
            req.setAttribute("authorFirstName", author.getFirstName());
            req.setAttribute("authorMiddleName", author.getMiddleName());
            req.setAttribute("authorLastName", author.getLastName());
            req.setAttribute("authorAbout", author.getAbout());
        }
        logger.info("Grabbed all of the book attributes to automatically display in edit form.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editBook.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao bookDao = new GenericDao(Book.class);
        GenericDao authorDao = new GenericDao(Author.class);

        int id = Integer.parseInt(req.getParameter("bookId"));
        String title = req.getParameter("bookTitle");
        String summary = req.getParameter("summary");
        int series = Integer.parseInt(req.getParameter("series"));
        String genre = req.getParameter("genre");
        String authorFirstName = req.getParameter("authorFirstName");
        String authorMiddleName = req.getParameter("authorMiddleName");
        String authorLastName = req.getParameter("authorLastName");
        String authorAbout = req.getParameter("authorAbout");

        Book bookToUpdate = (Book) bookDao.getById(id);
        Author authorToUpdate = bookToUpdate.getAuthor();
        bookToUpdate.setTitle(title);
        bookToUpdate.setSummary(summary);
        bookToUpdate.setSeries(series);
        bookToUpdate.setGenre(genre);

        authorToUpdate.setFirstName(authorFirstName);
        authorToUpdate.setMiddleName(authorMiddleName);
        authorToUpdate.setLastName(authorLastName);
        authorToUpdate.setAbout(authorAbout);

        bookDao.saveOrUpdate(bookToUpdate);
        authorDao.saveOrUpdate(authorToUpdate);
        logger.info("Book has been updated in the database.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editConfirmation.jsp");
        dispatcher.forward(req, resp);
    }
}
