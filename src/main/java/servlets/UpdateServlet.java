package servlets;

import DTO.StudentDTO;
import services.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    private final Behavior behavior = new Behavior();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String mark = request.getParameter("mark");
        String page = request.getParameter("page");
        try {
            int index = Integer.parseInt(id);
            int age1 = Integer.parseInt(age);
            int mark1 = Integer.parseInt(mark);
            StudentDTO studentDTO = StudentDTO.builder().id(index).name(name).surname(surname).age(age1).address(address).mark(mark1).build();
            behavior.updateStudent(index, studentDTO);
            request.setAttribute("update",true);
            request.setAttribute("student",studentDTO);
            getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("error11111");
            response.sendRedirect("/index?page=1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" update DO GET");
        String id = request.getParameter("id");
        String page = request.getParameter("page");
        try {
            Integer index = Integer.parseInt(id);
            StudentDTO studentDTO = behavior.readById(index);
            request.setAttribute("student", studentDTO);
            getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("Error");
            response.sendRedirect("/index?page=1");
        }

    }
}
