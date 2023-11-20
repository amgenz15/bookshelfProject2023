package amgenz.controller;

import amgenz.entity.*;
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

/**
 * A simple servlet to display a book's details.
 * @author amgenz
 */

@WebServlet(
        urlPatterns = {"/bookDetails"}
)

public class DisplayBook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao bookDao = new GenericDao(Book.class);
        GenericDao authorDao = new GenericDao(Author.class);
        int bookId;

        if (req.getParameter("submit").equals("bookDetails")) {
            bookId = Integer.parseInt(req.getParameter("bookId"));
            Book bookToDisplay = (Book) bookDao.getById(bookId);
            req.setAttribute("book", bookToDisplay);
            req.setAttribute("bookAuthor", authorDao.getByPropertyEqualEntity("book", bookToDisplay));
        }
        logger.info("The book info and their author have been grabbed from the database.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookProfile.jsp");
        dispatcher.forward(req, resp);
    }
}