package servlets.changepass;

import DAO.classes.UserDaoImpl;
import DAO.interfaces.UserDao;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePassword", urlPatterns = {"/changePass"})
public class ChangePassword extends HttpServlet {

    private final UserDao userDao = new UserDaoImpl();
    private User changeUser = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        changeUser = userDao.getUserByPassword(password);
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
            userDao.update(changeUser.getId(),changeUser);
            System.out.println("success change pass");
            resp.sendRedirect("/signUp");
        }
    }
}
