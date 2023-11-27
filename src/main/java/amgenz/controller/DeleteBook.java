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
 * A simple servlet to delete a book.
 * @author amgenz
 */

@WebServlet(
        urlPatterns = {"/deleteBook"}
)

public class DeleteBook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.error("In the doGet to delete a recipe.");
        GenericDao bookDao = new GenericDao(Book.class);

        if (req.getParameter("submit").equals("deleteBook")) {
            logger.info("In the if statement where book delete button was pushed.");
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            Book book = (Book) bookDao.getById(bookId);
            bookDao.delete(book);
            logger.info("Book had been deleted.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteConfirmation.jsp");
            dispatcher.forward(req, resp);

        }

    }
}