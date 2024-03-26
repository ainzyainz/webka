package DAO.interfaces;

import entities.Student;

import java.util.List;

public interface StudentDAO extends DAO<Student> {
    List<Student> getAllStudents();
    List<Student> getLimited(int x, int y);
    List<Student> getSearch(String search);
    int getNoOfRecords();
    Student findByUserId(int userId);
}
