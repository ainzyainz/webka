package DAO.interfaces;

import entities.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {
    List<Student> getAllStudents();
    List<Student> readByName(String name);
    List<Student> readBySurname(String surname);
    List<Student> readByAddress(String address);
    List<Student> readByAge(int age);
    List<Student> readByMark(int mark);
    List<Student> getLimited(int x, int y);
}
