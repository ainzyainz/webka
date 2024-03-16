import DAO.classes.StudentDAOImpl;
import entities.Student;
import services.Behavior;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        Student student = Student.builder().name("sd").surname("sdd").address("asd").age(23).mark(1).build();
        Student student2 = Student.builder().name("sd2").surname("sdd2").address("asd2").age(23).mark(1).build();
        Student student3 = Student.builder().name("sd23").surname("sdd23").address("asd23").age(33).mark(3).build();



        studentDAO.create(student);
        studentDAO.create(student2);

        Student read = studentDAO.read(1);
        System.out.println(read);



        Behavior behavior = new Behavior();
        behavior.readStudent("1").forEach(System.out::println);

    }

}