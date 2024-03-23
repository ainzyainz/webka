package servlets.changepass;

import DAO.classes.StudentDAOImpl;
import DAO.classes.UserDaoImpl;
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
import java.util.List;

@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgotPass"})
public class ForgotPassword extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        List<User> list = userDao.getUserByEmail(email);
        if (list==null){
            System.out.println("list is null");
            resp.sendRedirect("/forgotPass.jsp");
        }else{
            resp.sendRedirect("/changePass");
        }
    }
}
