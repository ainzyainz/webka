package servlets;

import DTO.StudentDTO;
import entities.Student;
import services.Behavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class Servlet2 extends HttpServlet {
    private final Behavior behavior = new Behavior();

    public void init() {
        System.out.println("penis");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ultrapenis");
        int page = 1;
        int perPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            List<StudentDTO> list = (List<StudentDTO>) request.getAttribute("sortedList");
            int noOfRecords = list.size();
            int pages = (int) Math.ceil(noOfRecords * 1.0 / perPage);
            System.out.println(pages);
            request.setAttribute("list", list);
            System.out.println(list);
            System.out.println(pages);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("currentPage", page);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("penis");
        int page = 1;
        int perPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            List<StudentDTO> list = behavior.readStudentLimited((page - 1) * perPage, perPage);
            int noOfRecords = behavior.getNoOfRecords();
            int pages = (int) Math.ceil(noOfRecords * 1.0 / perPage);
            System.out.println(pages);
            request.setAttribute("list", list);
            System.out.println(list);
            System.out.println(pages);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("currentPage", page);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
