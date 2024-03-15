package servlets;

import services.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/creating")
public class Servlet extends HttpServlet {
    private Behavior behavior = new Behavior();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var address = request.getParameter("address");
        var age = request.getParameter("age");
        var mark = request.getParameter("mark");
        var email = request.getParameter("email");

        if (behavior.createStudent(name, surname, address, age, mark, email) != null) {
            response.sendRedirect("/index");
            System.out.println("create success");
        } else {
            System.out.println("create failed");
            response.sendRedirect("/index");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
