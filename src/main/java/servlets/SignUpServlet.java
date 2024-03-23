package servlets;

import DAO.classes.UserDaoImpl;
import entities.User;
import net.bytebuddy.build.Plugin;
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
    private final UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        List<User> list = userDao.getRoleByLoginAndPassword(login, password);
        if (list==null){
            System.out.println("no such user");
            req.setAttribute("wrong",true);
            doGet(req,resp);
        }
        User user = list.get(0);
        if(user.getRole().equals(Roles.ADMIN)){
            resp.sendRedirect("index?page=1");
        }else {/*
            resp.sendRedirect("mainPageStudent");*/
            req.setAttribute("current",user);
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(req,resp);
        }
    }
}
