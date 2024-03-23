package servlets;

import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import entities.Student;
import entities.User;
import utils.roles.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/authorization"})
public class AuthorizationServlet extends HttpServlet {
    private final StudentDAOImpl studentDAO = new StudentDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String mark = req.getParameter("mark");
        String address = req.getParameter("address");
        String age = req.getParameter("age");
        try {
            int mark1 = Integer.parseInt(mark);
            int age1 = Integer.parseInt(age);
            User user = User.builder().role(Roles.USER).login(login).password(password).build();
            Student student = Student.builder()
                    .user(user)
                    .mark(mark1)
                    .name(name)
                    .surname(surname)
                    .age(age1)
                    .address(address)
                    .build();
            studentDAO.create(student);


        }catch (NumberFormatException e){
            System.out.println("error parseInt");
        }
        resp.sendRedirect("/webka_war_exploded/mainPageStudent");
    }
}
