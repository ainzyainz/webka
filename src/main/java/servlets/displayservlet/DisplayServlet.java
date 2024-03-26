package servlets.displayservlet;

import DTO.StudentDTO;
import DTO.UserDTO;
import services.studentservice.Behavior;
import utils.roles.Roles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "DisplayServlet", urlPatterns = {"/display"})
public class DisplayServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DisplayServlet.class.getName());
    private final Behavior behavior = Behavior.getINSTANCE();
    private List<StudentDTO> list = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_POST_START);
        int page = 0;
        int perPage = ROW_IN_PAGE;
        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("current");

        if (request.getParameter(PAGE) != null) {
            try {
                page = Integer.parseInt(request.getParameter(PAGE));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (request.getSession().getAttribute("sortedList") != null) {
                this.list = (List<StudentDTO>) request.getSession().getAttribute("sortedList");
            }

            if (list == null) {
                doGet(request, response);
            }

            List<StudentDTO> result = new ArrayList<>();
            for (int i = (page - 1) * perPage; i < perPage * page; i++) {
                if (i < list.size()) {
                    result.add(list.get(i));
                } else {
                    break;
                }
            }
            int noOfRecords = list.size();
            int pages = (int) Math.ceil(noOfRecords * PAGE_COEFFICIENT / perPage);

            request.setAttribute("list", result);
            request.setAttribute("currentPage", page);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("pageName", "index");
            request.setAttribute("pageMethod", "post");
            System.out.println("page method is set to post");

            if (currentUser.getRole().equals(Roles.USER)) {
                System.out.println("you're a user");
                request.setAttribute("current",currentUser);
                getServletContext().getRequestDispatcher("/pageForStudent.jsp").forward(request, response);
            }
            System.out.println(page);
            if ((currentUser.getRole().equals(Roles.ADMIN))){
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, DO_GET_START);
        request.getSession().setAttribute("sortedList", null);
        list = null;
        int page;
        int perPage = ROW_IN_PAGE;
        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("current");

        if (request.getParameter(PAGE) != null) {
            page = Integer.parseInt(request.getParameter(PAGE));
             list = behavior.readStudentLimited((page - 1) * perPage, perPage);
            int noOfRecords = behavior.getNoOfRecords();
            int pages = (int) Math.ceil(noOfRecords * PAGE_COEFFICIENT / perPage);
            request.setAttribute("list", list);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("currentPage", page);

            if (currentUser.getRole().equals(Roles.USER)) {
                request.setAttribute("current", currentUser);
                list = null;
                getServletContext().getRequestDispatcher("/pageForStudent.jsp").forward(request, response);
            }
            if ((currentUser.getRole().equals(Roles.ADMIN))){
                list = null;
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            LOGGER.log(Level.INFO, PAGE_IS_NULL);
        }
    }
}
