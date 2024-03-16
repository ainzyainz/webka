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
import java.util.List;

@WebServlet(name = "ReadServlet", urlPatterns = "/read")
public class ReadServlet extends HttpServlet {
    private Behavior behavior = new Behavior();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("penispenis");
        String search = request.getParameter("s");
        System.out.println(search);
        List<StudentDTO> studentDTOList = behavior.readStudent(search);
        System.out.println(studentDTOList);
        if (studentDTOList==null||studentDTOList.isEmpty()){
            response.sendRedirect("/index");
            return;
            //TODO придумать как обработать ситуацию когда никого не нашел
        }
        displayAlteredList(studentDTOList,request,response);
    }
    public void displayAlteredList(List<StudentDTO> alteredList, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("penis penis");
        request.setAttribute("list",alteredList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
