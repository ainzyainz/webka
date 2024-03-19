import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import entities.Student;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.getSearch("1").forEach(System.out::println);
    }
}