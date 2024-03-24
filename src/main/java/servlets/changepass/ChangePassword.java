package servlets.changepass;

import DAO.classes.UserDaoImpl;
import DAO.interfaces.UserDao;
import DTO.UserDTO;
import entities.User;
import services.studentservice.UserBehavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePassword", urlPatterns = {"/changePass"})
public class ChangePassword extends HttpServlet {

    private UserBehavior userBehavior = UserBehavior.getINSTANCE();
    private UserDTO changeUser = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if (password != null) {
            changeUser = userBehavior.getUserByPassword(password);
        } else if (email != null) {
            changeUser = userBehavior.getUserByEmail(email);
        }
        System.out.println(changeUser);
        if (changeUser != null) {
            getServletContext().getRequestDispatcher("/changePass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String newPass = req.getParameter("new");

        if (changeUser == null || newPass == null) {
            resp.sendRedirect("/forgotPass.jsp");
        } else {
            changeUser.setPassword(newPass);
            userBehavior.update(changeUser.getId(), changeUser);
            System.out.println("success change pass");
            resp.sendRedirect("/signUp");
        }
    }
}
