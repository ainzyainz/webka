package DAO.classes;


import DAO.interfaces.StudentDAO;
import entities.Student;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {

    private final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());


    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student create(Student obj) {
        return super.create(obj);
    }

    @Override
    public Student read(int id) {
        return super.read(id);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    public List<Student> getAllStudents() {
        return getEntityManager()
                .createQuery("select s from Student s", getEntityClass())
                .getResultList();
    }


    @Override
    public List<Student> readByName(String name) {
        Query query = getEntityManager()
                .createQuery("select s from Student s where name = :value",getEntityClass());
        query.setParameter("value",name);
        List<Student> list = query.getResultList();
        LOGGER.log(Level.INFO, "bla bla");
        return list;
    }

    @Override
    public List<Student> readBySurname(String surname) {
        Query query = getEntityManager()
                .createQuery("from Student where surname = :value",getEntityClass());
        query.setParameter("value",surname);
        List<Student> list = query.getResultList();
        LOGGER.log(Level.INFO, "bla bla");
        return list;
    }

    @Override
    public List<Student> readByAddress(String address) {
        Query query = getEntityManager()
                .createQuery("from Student where address = :value",getEntityClass());
        query.setParameter("value",address);
        List<Student> list = query.getResultList();
        LOGGER.log(Level.INFO, "bla bla");
        return list;
    }

    @Override
    public List<Student> readByAge(int age) {
        Query query = getEntityManager()
                .createQuery("from Student where age = :value",getEntityClass());
        query.setParameter("value",age);
        List<Student> list = query.getResultList();
        LOGGER.log(Level.INFO, "bla bla");
        return list;
    }

    @Override
    public List<Student> readByMark(int mark) {
        Query query = getEntityManager()
                .createQuery("from Student where mark = :value",getEntityClass());
        query.setParameter("value",mark);
        List<Student> list = query.getResultList();
        LOGGER.log(Level.INFO, "bla bla");
        return list;
    }
}
