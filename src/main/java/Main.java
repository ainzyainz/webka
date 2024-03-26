import DAO.classes.StudentDAOImpl;
import DAO.classes.UserDaoImpl;
import DAO.interfaces.StudentDAO;
import entities.Country;
import entities.Student;
import entities.User;
import utils.roles.Roles;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();

//        for (int i = 0; i < 20; i++) {
//            Country country = Country.builder().countryName(i + " ").build();
//            User user2 = User.builder()
//                    .email(String.valueOf(i))
//                    .role(Roles.valueOf(Roles.USER.toString()))
//                    .password("123")
//                    .build();
//            Student student2 = Student.builder()
//                    .name(i + "lexa")
//                    .address("gd" + i)
//                    .age(20)
//                    .surname("daineko")
//                    .mark(10)
//                    .country(country)
//                    .user(user2)
//                    .build();
//            studentDAO.create(student2);
//        }
        User user = User.builder()
                .email("lera")
                .role(Roles.valueOf(Roles.ADMIN.toString()))
                .password("123")
                .build();
        Student student = Student.builder()
                .name("Lera")
                .address("minsk")
                .age(20)
                .surname("Stepanova")
                .mark(10)
                .user(user)
                .build();
        studentDAO.create(student);

    }
}