package services.studentservice;

import DAO.classes.UserDaoImpl;
import entities.User;

public class UserBehavior {

    private static final UserBehavior INSTANCE = new UserBehavior();
    private UserDaoImpl userDao = new UserDaoImpl();

    private UserBehavior() {
    }

    public User findById(int id){
        return userDao.read(id);
    }

    public static UserBehavior getINSTANCE() {
        return INSTANCE;
    }
}
