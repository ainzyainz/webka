package servlets.displayservlet;

import DTO.StudentDTO;
import services.studentservice.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "DisplayServlet", urlPatterns = {"/display"})
public class DisplayServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private List<StudentDTO> list = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DISPLAY POST");
        int page;
        int perPage = ROW_IN_PAGE;
        if (request.getParameter(PAGE) != null) {
            page = Integer.parseInt(request.getParameter(PAGE));
            if (request.getAttribute("sortedList") != null){
                this.list = (List<StudentDTO>) request.getAttribute("sortedList");
            }
            if (list == null || request.getParameter("update")!=null) {
                doGet(request, response);
            }

            List<StudentDTO> result = new ArrayList<>();
            for (int i = (page - 1) * perPage; i < perPage * page; i++) {
                if (i < list.size()){
                    result.add(list.get(i));
                } else {
                    System.out.println("мы тут в doPost за эту таску стоим");
                    break;
                }
            }
            int noOfRecords = list.size();
            int pages = (int) Math.ceil(noOfRecords * 1.0 / perPage);

            request.setAttribute("list", result);
            request.setAttribute("currentPage", page);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("pageName", "index");
            request.setAttribute("pageMethod", "post");
            System.out.println("page method is set to post");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet 2 do get");
        list = null;
        int page;
        int perPage = ROW_IN_PAGE;

        if (request.getParameter(PAGE) != null) {
            page = Integer.parseInt(request.getParameter(PAGE));
            List<StudentDTO> list = behavior.readStudentLimited((page - 1) * perPage, perPage);
            int noOfRecords = behavior.getNoOfRecords();
            int pages = (int) Math.ceil(noOfRecords * PAGE_COEFFICIENT / perPage);
            request.setAttribute("list", list);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("currentPage", page);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            System.out.println("page is null");
        }
    }
}
