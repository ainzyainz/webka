package servlets.createservlet;

import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;
import services.studentservice.Behavior;
import utils.roles.Roles;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

@WebServlet(name = "CreateServlet", urlPatterns = "/creating")
public class CreateServlet extends HttpServlet {

    private final Behavior behavior = Behavior.getINSTANCE();
    private final Logger LOGGER = Logger.getLogger(CreateServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO, DO_POST_START);

        var name = request.getParameter("name");
        var surname = request.getParameter("surname");
        var address = request.getParameter("address");
        var age = request.getParameter("age");
        var mark = request.getParameter("mark");
        var email = request.getParameter("email");
        var password = request.getParameter("password");
        var page = request.getParameter("page");

        int intAge;
        int intMark;
        try{
            intAge = Integer.parseInt(age);
            intMark = Integer.parseInt(mark);
            UserDTO userDTO = UserDTO.builder().email(email).password(password).role(Roles.USER).build();
            StudentDTO studentDTO = StudentDTO.builder().name(name).surname(surname).address(address).age(intAge).mark(intMark).build();
            studentDTO.setUserDTO(userDTO);
            if (behavior.createStudent(studentDTO)==null){
                LOGGER.log(Level.INFO, CRETE_FAILED);
                return;
            }
            LOGGER.log(Level.INFO, CREATE_SUCCESS);
        }catch (NumberFormatException e){
            LOGGER.log(Level.INFO, CRETE_FAILED);
        }


        response.sendRedirect("/index?page=" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO, DO_GET_START);
        doPost(request, response);
    }
}
