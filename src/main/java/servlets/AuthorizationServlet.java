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
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        try {
            int age1 = Integer.parseInt(age);
            User user = User.builder().role(Roles.USER).email(email).password(password).build();

            Student student = Student.builder()
                    .mark(-1)
                    .user(user)
                    .name(name)
                    .surname(surname)
                    .age(age1)
                    .address("unknown")
                    .build();

            studentDAO.create(student);

            user.setStudent(student);

            req.setAttribute("current",user);
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(req,resp);
        }catch (NumberFormatException e){
            System.out.println("error parseInt");
        }
    }
}
