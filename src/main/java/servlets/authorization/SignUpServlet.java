package servlets.authorization;

import DTO.StudentDTO;
import DTO.UserDTO;
import services.studentservice.Behavior;
import utils.roles.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signUp"})
public class SignUpServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        req.getSession().setAttribute("password", password);
        StudentDTO student = behavior.getStudentOfLoginAndPassword(login, password);

        if (student == null) {
            System.out.println("no such user");
            req.setAttribute("wrong",true);
            doGet(req, resp);
            return;
        }
        UserDTO user = student.getUserDTO();

        if (student.getUserDTO().getRole().equals(Roles.ADMIN)) {
            req.getSession().setAttribute("current", student.getUserDTO());
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", login);
            req.getSession().setAttribute("role", student.getUserDTO().getRole());
            resp.sendRedirect("index?page=1");
        } else {
            user.setStudent(student);
            req.setAttribute("current", user);
            req.getSession().setAttribute("current", user);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", login);
            req.getSession().setAttribute("role", user.getRole());
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(req,resp);
        }
    }
}
