package servlets.updateservlet;

import DTO.StudentDTO;
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

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final Logger LOGGER = Logger.getLogger(UpdateServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO, DO_POST_START);

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String mark = request.getParameter("mark");

        try {
            int index = Integer.parseInt(id);
            int age1 = Integer.parseInt(age);
            int mark1 = Integer.parseInt(mark);
            StudentDTO studentDTO = StudentDTO.builder().name(name).surname(surname).age(age1).address(address).mark(mark1).build();
            behavior.updateStudent(index, studentDTO);
            response.sendRedirect("/index?page=1");
        } catch (NumberFormatException e) {
            response.sendRedirect("/index?page=1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_GET_START);

        String id = request.getParameter("id");
        String page = request.getParameter("page");
        try {
            int index = Integer.parseInt(id);
            StudentDTO studentDTO = behavior.readById(index);
            request.setAttribute("student", studentDTO);
            getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, INCORRECT_TYPE);
            response.sendRedirect("/index?page=1");
        }

    }
}
