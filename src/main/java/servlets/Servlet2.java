package servlets;

import DTO.StudentDTO;
import services.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet
public class Servlet2 extends HttpServlet {
    private final Behavior behavior = new Behavior();
    public void init(){
        System.out.println("penis");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("penis");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("penis");
        List<StudentDTO> list = behavior.getAllStudents();
        request.setAttribute("list",list);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
