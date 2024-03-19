package servlets.createservlet;

import services.studentservice.Behavior;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/creating")
public class CreateServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var address = request.getParameter("address");
        var age = request.getParameter("age");
        var mark = request.getParameter("mark");
        var email = request.getParameter("email");
        String page = request.getParameter("page");

        // предлагает не проверять if
        if (behavior.createStudent(name, surname, address, age, mark, email) != null) {
            response.sendRedirect("/index?page=" + page);
        } else {
            response.sendRedirect("/index?page=" + page);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    doPost(request, response);
    }
}
