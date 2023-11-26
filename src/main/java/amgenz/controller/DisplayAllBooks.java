package amgenz.controller;

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

/**
 * A servlet to display all books.
 * @author amgenz
 */

@WebServlet (
        urlPatterns = {"/displayBooks"}
)
public class DisplayAllBooks extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("In the doGet to display all books.");
        GenericDao bookDao = new GenericDao(Book.class);
        req.setAttribute("books", bookDao.getAll());
        logger.info("All books have been grabbed from the database.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allBooks.jsp");
        dispatcher.forward(req, resp);
    }

}
