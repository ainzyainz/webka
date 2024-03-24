package DAO.interfaces;

import entities.User;

import java.util.List;

public interface UserDao  extends DAO<User>{

    User getUserByPassword(String password);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    List<User> getRoleByLoginAndPassword(String login, String password);
}
