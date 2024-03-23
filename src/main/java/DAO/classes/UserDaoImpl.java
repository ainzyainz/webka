package DAO.classes;

import DAO.interfaces.UserDao;
import entities.Student;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static utils.constant.ConstantsContainer.*;
import static utils.constant.ConstantsContainer.GET_ALL_STUDENT_SUCCESSFUL;

public class UserDaoImpl extends DAOImpl<User> implements UserDao {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User create(User object) {
        return super.create(object);
    }

    @Override
    public User read(int id) {
        return super.read(id);
    }

    @Override
    public User update(int id, User object) {
        return super.update(id, object);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.log(Level.INFO, START_GET_ALL_STUDENT);
        List<User> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_ALL_USER_QUERY, getEntityClass())
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_ALL_STUDENT_SUCCESSFUL);

        return list;
    }

    @Override
    public List<User> getRoleByLoginAndPassword(String email, String password) {
        String query = "select* from user where email = '" + email + "' and password ='" + password + "';";
        Query query1 = getEntityManager().createNativeQuery(query, User.class);
        List<User> users = query1.getResultList();
        if(users.isEmpty()){
            LOGGER.log(Level.INFO, "не найдено");
            return null;
        }
        return users;
    }
    public List<User> getUserByEmail(String email){
        String query = "select* from user where email = '" + email+"'";
        Query query1 = getEntityManager().createNativeQuery(query, User.class);
        List<User> users = query1.getResultList();
        System.out.println(users);
        if (users.isEmpty()){
            return null;
        }else{
            return users;
        }
    }
}
