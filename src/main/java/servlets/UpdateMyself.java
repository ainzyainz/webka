package servlets;

import DTO.StudentDTO;
import DTO.UserDTO;
import services.studentservice.Behavior;
import services.studentservice.UserBehavior;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateMyself", urlPatterns = "/updateMyself")
public class UpdateMyself extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var id = request.getParameter("id");
        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var address = request.getParameter("address");
        var age = request.getParameter("age");
        var mark = request.getParameter("mark");
        var studentId = request.getParameter("studentId");

        try{
            int intId = Integer.parseInt(id);
            int intStudentId = Integer.parseInt(studentId);
            int intAge = Integer.parseInt(age);
            int intMark = Integer.parseInt(mark);

            StudentDTO studentDTO = StudentDTO.builder()
                    .name(name)
                    .userDTO(userBehavior.findById(intId))
                    .surname(surname)
                    .address(address)
                    .age(intAge)
                    .mark(intMark)
                    .build();

            behavior.updateStudent(intStudentId,studentDTO);
            getServletContext().getRequestDispatcher("/mainPageStudent").forward(request,response);
        } catch (NumberFormatException e){
            System.out.println("it's not numbers");
            response.sendRedirect("/mainPageStudent");
        }
    }
}
