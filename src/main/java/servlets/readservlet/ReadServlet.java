package servlets.readservlet;

import DTO.StudentDTO;
import services.studentservice.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "ReadServlet", urlPatterns = {"/read"})
public class ReadServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final Logger LOGGER = Logger.getLogger(ReadServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_POST_START);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_GET_START);

        String search = request.getParameter("s");
        List<StudentDTO> studentDTOList = behavior.readStudents(search);
        if (studentDTOList == null || studentDTOList.isEmpty()) {
            response.sendRedirect("/display?page=1");
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
            return;
        }
        displayAlteredList(studentDTOList, request, response);
    }

    public void displayAlteredList(List<StudentDTO> alteredList, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("sortedList", alteredList);
        getServletContext().getRequestDispatcher("/display?page=1").forward(request, response);
    }
}