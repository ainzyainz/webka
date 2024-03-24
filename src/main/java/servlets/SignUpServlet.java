package servlets;

import DAO.classes.UserDaoImpl;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.User;
import net.bytebuddy.build.Plugin;
import services.studentservice.Behavior;
import services.studentservice.UserBehavior;
import utils.roles.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signUp"})
public class SignUpServlet extends HttpServlet {

    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();
    private final Behavior behavior = Behavior.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        StudentDTO student = behavior.getStudentOfLoginAndPassword(login, password);
        System.out.println(student);
        if (student==null){
            System.out.println("no such user");
            req.setAttribute("wrong",true);
            doGet(req,resp);
        }
        UserDTO user = student.getUserDTO();


        if(student.getUserDTO().getRole().equals(Roles.ADMIN)){
            System.out.println("admin");
            req.getSession().setAttribute("current", student.getUserDTO());
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", login);
            req.getSession().setAttribute("role", student.getUserDTO().getRole());
            resp.sendRedirect("index?page=1");
        }else {
            user.setStudent(student);
            System.out.println(user);
            System.out.println(user.getStudent());
            req.setAttribute("current", user);
            req.getSession().setAttribute("current", user);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", login);
            req.getSession().setAttribute("role", user.getRole());
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(req,resp);
        }
    }
}
