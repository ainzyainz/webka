import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import entities.Student;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.update(4,Student.builder().build());
        System.out.println(studentDAO.getAllStudents());
    }
}