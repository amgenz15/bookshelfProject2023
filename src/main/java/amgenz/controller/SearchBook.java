package amgenz.controller;

import amgenz.entity.Book;
import amgenz.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to search for books.
 * @author amgenz
 */

@WebServlet(
        urlPatterns = {"/searchBook"}
)

public class SearchBook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("In the doGet to search books.");
        GenericDao dao = new GenericDao(Book.class);
        if (req.getParameter("submit").equals("search")) {
            logger.info("In the if statement where search button was pushed.");
            req.setAttribute("books", dao.getByPropertyLike("title", req.getParameter("searchBookTitle")));
            logger.info("Here is the found book/s:");

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
