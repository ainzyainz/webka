package servlets.changepass;

import DTO.UserDTO;
import services.userservice.UserBehavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePassword", urlPatterns = {"/changePass"})
public class ChangePassword extends HttpServlet {

    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();
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
        System.out.println(changeUser + " changePassword get");
        if (changeUser != null) {
            getServletContext().getRequestDispatcher("/changePass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String newPass = req.getParameter("new");
        String email = req.getParameter("email");

        if (changeUser == null || newPass == null) {
            System.out.println(changeUser + "doPost chPass");
            System.out.println(newPass + " doPost chPass");
            resp.sendRedirect("/forgotPass.jsp");
        } else {
            changeUser.setPassword(newPass);
            UserDTO newUser = userBehavior.update(changeUser.getId(), changeUser);
            req.getSession().setAttribute("password", newPass);
            req.setAttribute("password", newPass);
            req.setAttribute("current", newUser);
            System.out.println("success change pass");
            resp.sendRedirect("/signUp");
        }
    }
}
