import DAO.classes.StudentDAOImpl;
import entities.Student;
import services.Behavior;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.getAllStudents());
        //  studentDAO.getSearch("1").forEach(System.out::println);
    }

}