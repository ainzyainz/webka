package servlets.createservlet;

import services.studentservice.Behavior;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "CreateServlet", urlPatterns = "/creating")
public class CreateServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final Logger LOGGER = Logger.getLogger(CreateServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO, DO_POST_START);

        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var address = request.getParameter("address");
        var age = request.getParameter("age");
        var mark = request.getParameter("mark");
        var email = request.getParameter("email");
        String page = request.getParameter("page");

        if (behavior.createStudent(name, surname, address, age, mark, email) != null) {
            LOGGER.log(Level.INFO, CREATE_SUCCESS);
        } else {
            LOGGER.log(Level.INFO, CRETE_FAILED);
        }
        response.sendRedirect("/index?page=" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO, DO_GET_START);
        doPost(request, response);
    }
}
