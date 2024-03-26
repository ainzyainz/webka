package servlets.updateservlet;

import DTO.CountryDTO;
import DTO.StudentDTO;
import DTO.UserDTO;
import services.studentservice.Behavior;
import services.userservice.UserBehavior;

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
        getServletContext().getRequestDispatcher("/mainPageStudent").forward(req, resp);
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
        var countryName = request.getParameter("country");

        try {
            int intId = Integer.parseInt(id);
            int intStudentId = Integer.parseInt(studentId);
            int intAge = Integer.parseInt(age);
            int intMark = Integer.parseInt(mark);

            UserDTO userDTO = userBehavior.findById(intId);
            CountryDTO country = CountryDTO.builder().countryName(countryName).build();

            StudentDTO studentDTO = StudentDTO.builder()
                    .name(name)
                    .userDTO(userDTO)
                    .surname(surname)
                    .address(address)
                    .age(intAge)
                    .mark(intMark)
                    .countryDTO(country)
                    .build();


            userDTO.setStudent(behavior.updateStudent(intStudentId, studentDTO));
            request.getSession().setAttribute("current", userDTO);
           doGet(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/mainPageStudent");
        }
    }
}
