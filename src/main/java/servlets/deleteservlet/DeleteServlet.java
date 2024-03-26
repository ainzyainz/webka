package servlets.deleteservlet;

import services.studentservice.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteMe")
public class DeleteServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final Logger LOGGER = Logger.getLogger(DeleteServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_POST_START);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_GET_START);

        String id = request.getParameter("id");
        String page = request.getParameter("page");

        if (behavior.deleteStudent(id) == -1) {
            LOGGER.log(Level.INFO, DELETE_FAILED);
        } else {
            LOGGER.log(Level.INFO, DELETE_SUCCESS);
        }
        getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
    }
}
