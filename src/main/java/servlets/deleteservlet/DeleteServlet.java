package servlets.deleteservlet;

import services.studentservice.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteMe")
public class DeleteServlet extends HttpServlet {
    private final Behavior behavior = Behavior.getINSTANCE();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //TODO при удалении всех дтошек с одной page возвращаемся на предыдущую
    }

    // хуйня какая-то происходит
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String page = request.getParameter("page");
        if (behavior.deleteStudent(id) == -1){
            getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/index?page=" + page).forward(request, response);
        }
    }
}
