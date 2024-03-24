package servlets.changepass;

import entities.User;
import services.studentservice.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VerifyPassword", urlPatterns = {"/verifyPass"})
public class VerifyPassword extends HttpServlet {
    Behavior behavior = Behavior.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/verifyPass.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String assumedPass = req.getParameter("assumedPass");
        User current = (User) req.getAttribute("current");
        if (assumedPass==null||current==null||!current.getPassword().equals(assumedPass)){
            System.out.println("password verification error");
            resp.sendRedirect("/singUp");
        }
        resp.sendRedirect("/changePass");
    }
}
