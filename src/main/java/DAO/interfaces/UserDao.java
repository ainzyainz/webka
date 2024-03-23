package DAO.interfaces;

import entities.User;
import org.apache.taglibs.standard.lang.jstl.Literal;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    List<User> getRoleByLoginAndPassword(String login, String password);
}
