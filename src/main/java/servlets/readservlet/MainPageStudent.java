package servlets.readservlet;

import DTO.UserDTO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MainPageStudent", urlPatterns = "/mainPageStudent")
public class MainPageStudent extends HttpServlet {

    private UserDTO currentUser = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        if (currentUser == null) {
            System.out.println("ты долбоеб");
            resp.sendRedirect("signUp");
            return;
        }
        resp.sendRedirect("/display?page=1");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        currentUser = (UserDTO) req.getSession().getAttribute("current");
        doGet(req, resp);
    }
}
