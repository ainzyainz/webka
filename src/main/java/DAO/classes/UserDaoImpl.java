package DAO.classes;

import DAO.interfaces.UserDao;
import entities.User;

import javax.persistence.EntityManager;
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
        String query = String.format("%s%s%s%s%s", GET_USER_BY_EMAIL_QUERY, email, AND_PASSWORD, password, END_QUERY2);
        List<User> users = getEntityManager().createNativeQuery(query, User.class).getResultList();
        if (users.isEmpty()) {
            LOGGER.log(Level.INFO, GET_ROLE_NOT_FOUND );
            return null;
        }
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = String.format("%s%s%s", GET_USER_BY_EMAIL_QUERY, email, END_QUERY);
        List<User> users = getEntityManager().createNativeQuery(query, User.class).getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.stream().findFirst().orElse(null);
        }
    }

    @Override
    public User getUserByPassword(String password) {
        String query = String.format("%s%s%s", GET_USER_BY_PASSWORD_QUERY, password, END_QUERY);
        List<User> users = getEntityManager().createNativeQuery(query, User.class).getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.stream().findFirst().orElse(null);
        }
    }
}
