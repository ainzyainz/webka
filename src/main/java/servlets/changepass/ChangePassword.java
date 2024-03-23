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

@WebServlet(name = "ChangePassword", urlPatterns = {"/changePass"})
public class ChangePassword extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private User changeUser = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        changeUser = userDao.getUserByEmail(email).get(0);
        getServletContext().getRequestDispatcher("/changePass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newPass = req.getParameter("new");
        System.out.println(changeUser);
        System.out.println(newPass);

        if (changeUser==null || newPass == null){
            System.out.println("xyi");
            resp.sendRedirect("/forgotPass.jsp");
        }else{
            changeUser.setPassword(newPass);
            userDao.update(changeUser.getId(),changeUser);
            System.out.println("success change pass");
            resp.sendRedirect("/signUp");
        }
    }
}
