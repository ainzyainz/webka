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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet
public class Servlet2 extends HttpServlet {
    private final Behavior behavior = new Behavior();
    private List<StudentDTO> list = null;
    public void init() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ultrapenis");
        int page = 1;
        int perPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            if (request.getAttribute("sortedList")!=null){
                this.list = (List<StudentDTO>) request.getAttribute("sortedList");
            }
            if (list==null) {
                doGet(request,response);
            }

            List<StudentDTO> result = new ArrayList<>();
            System.out.println("---");
            for (int i = (page-1)*perPage; i < perPage*page; i++) {
                if (i<list.size()){
                    result.add(list.get(i));
                }else{
                    break;
                }
            }
            int noOfRecords = list.size();
            int pages = (int) Math.ceil(noOfRecords * 1.0 / perPage);
            System.out.println(pages);
            request.setAttribute("list", result);
            System.out.println(list);
            request.setAttribute("currentPage", page);
            request.setAttribute("noOfPages",pages);
            request.setAttribute("pageName", "index");
            request.setAttribute("pageMethod", "post");
            System.out.println("page method is set to post");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        list=null;
        int page = 1;
        int perPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            List<StudentDTO> list = behavior.readStudentLimited((page - 1) * perPage, perPage);
            int noOfRecords = behavior.getNoOfRecords();
            int pages = (int) Math.ceil(noOfRecords * 1.0 / perPage);
            request.setAttribute("list", list);
            request.setAttribute("noOfPages", pages);
            request.setAttribute("currentPage", page);
            request.setAttribute("pageMethod", "get");
            System.out.println("page method is set to get");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            System.out.println("page is null");
        }
    }
}
