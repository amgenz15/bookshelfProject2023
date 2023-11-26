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

        logger.info("In the doGet to display book details.");
        GenericDao bookDao = new GenericDao(Book.class);

        if (req.getParameter("submit").equals("bookDetails")) {
            logger.info("In the if statement where 'Show Details' button was pushed.");
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            req.setAttribute("book", bookDao.getById(bookId));
            logger.info("Book details have been grabbed from the database.");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }
}