package servlets;

import DAO.classes.StudentDAOImpl;
import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "MainPageStudent", urlPatterns = "/mainPageStudent")
public class MainPageStudent extends HttpServlet {
    private final StudentDAOImpl studentDAO = new StudentDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentDAO.getAllStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/pageForStudent.jsp").forward(req, resp);
    }
}
