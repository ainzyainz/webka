import DAO.classes.StudentDAOImpl;
import DAO.classes.UserDaoImpl;
import DAO.interfaces.StudentDAO;
import entities.Student;
import entities.User;
import services.studentservice.Behavior;
import services.studentservice.UserBehavior;
import utils.roles.Roles;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();

        User user = User.builder()
                .email("lera")
                .role(Roles.valueOf(Roles.ADMIN.toString()))
                .password("123")
                .build();
        Student student = Student.builder()
                .name("Lera")
                .address("gfd")
                .age(20)
                .surname("Stepanova")
                .mark(10)
                .user(user)
                .build();
        UserDaoImpl userDao = new UserDaoImpl();
        studentDAO.create(student);
        List<Student> list = studentDAO.getAllStudents();
        list.forEach(System.out::println);
        System.out.println(Roles.USER);
        List<User> users = userDao.getRoleByLoginAndPassword("lera", "123");
        for (User u : users
        ) {
            System.out.println(u.getRole());
        }

        Behavior behavior = Behavior.getINSTANCE();
        System.out.println(
                behavior.getStudentOfLoginAndPassword("asdsadasd","asdasdasd"));


    }
}