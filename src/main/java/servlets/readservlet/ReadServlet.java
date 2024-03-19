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

@WebServlet(name = "ReadServlet", urlPatterns = {"/read"})
public class ReadServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("s");
        System.out.println(behavior.getAllStudents());
        List<StudentDTO> studentDTOList = behavior.readStudents(search);
        System.out.println(studentDTOList);
        if (studentDTOList == null || studentDTOList.isEmpty()) {
            response.sendRedirect("/index?page=1");
            return;
            //TODO придумать как обработать ситуацию когда никого не нашел
        }
        displayAlteredList(studentDTOList, request, response);
    }

    public void displayAlteredList(List<StudentDTO> alteredList, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sortedList", alteredList);
        getServletContext().getRequestDispatcher("/index?page=1").forward(request, response);
    }
}