package DAO.classes;


import DAO.interfaces.StudentDAO;
import entities.Student;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.constant.ConstantsContainer.*;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {

    private final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());
    private int noOfRecords;

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student create(Student obj) { return super.create(obj); }

    @Override
    public Student read(int id) {
        return super.read(id);
    }

    @Override
    public Student update(int id, Student student) {return super.update(id, student); }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public List<Student> getAllStudents() {
        LOGGER.log(Level.INFO, START_GET_ALL_STUDENT);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_ALL_STUDENT_QUERY, getEntityClass())
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_ALL_STUDENT_SUCCESSFUL);

        return list;
    }

    @Override
    public int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public List<Student> getSearch(String search) {
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                .createQuery(GET_SEARCH, getEntityClass())
                 .setParameter(VALUE, search)
                 .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        return list;
    }

    @Override
    public List<Student> getLimited(int x, int y) {
        Query query = getEntityManager().createQuery(FROM_STUDENT, getEntityClass());
        if (!query.getResultList().isEmpty()){
            this.noOfRecords = getAllStudents().size();
        }
        query.setFirstResult(x);
        query.setMaxResults(y);

        return (List<Student>) query.getResultList();
    }
}
