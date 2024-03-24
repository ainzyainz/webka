package servlets;

import DAO.classes.StudentDAOImpl;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;
import services.studentservice.Behavior;
import services.studentservice.UserBehavior;
import utils.roles.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/authorization"})
public class AuthorizationServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();


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
            UserDTO user = UserDTO.builder().role(Roles.USER).email(email).password(password).build();

            StudentDTO student = StudentDTO.builder()
                    .mark(-1)
                    .userDTO(user)
                    .name(name)
                    .surname(surname)
                    .age(age1)
                    .address("unknown")
                    .build();

            if (userBehavior.alreadyExists(user)){
                req.setAttribute("wrong",true);
                doGet(req,resp);
                return;
            }

            req.getSession().setAttribute("current", user);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("role", Roles.USER);


            student.setUserDTO(user);
            user.setStudent(student);
            behavior.createStudent(student);
            req.setAttribute("current", user);
            req.getSession().setAttribute("current", user);
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(req,resp);
        } catch (NumberFormatException e){
            System.out.println("error parseInt");
        }
    }
}
