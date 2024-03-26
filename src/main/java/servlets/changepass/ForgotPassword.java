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

@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgotPass"})
public class ForgotPassword extends HttpServlet {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(req, resp);
    }
}
