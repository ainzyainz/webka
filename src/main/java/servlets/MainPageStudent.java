package servlets;

import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;
import services.studentservice.Behavior;
import services.studentservice.UserBehavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainPageStudent", urlPatterns = "/mainPageStudent")
public class MainPageStudent extends HttpServlet {

    private Behavior behavior = Behavior.getINSTANCE();
    private UserBehavior userBehavior = UserBehavior.getINSTANCE();
    private UserDTO currentUser = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<StudentDTO> students = behavior.getAllStudents();
        req.setAttribute("students", students);

        if (currentUser == null) {
            System.out.println("ты долбоеб");
            resp.sendRedirect("signUp");
            return;
        }
              req.getRequestDispatcher("pageForStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentUser = (UserDTO) req.getSession().getAttribute("current");
        doGet(req, resp);
    }
}
