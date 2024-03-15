package servlets;

import services.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteMe")
public class DeleteServlet extends HttpServlet {
    private final Behavior behavior = new Behavior();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (behavior.deleteStudent(id)==-1){
            response.sendRedirect("/index");
            System.out.println("delete failed");
        } else {
            System.out.println("delete success");
            response.sendRedirect("/index");
        }
    }
}
