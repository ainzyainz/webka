package services.studentservice;

import DAO.classes.StudentDAOImpl;
import DAO.classes.UserDaoImpl;
import entities.User;

public class UserBehavior {
    private UserDaoImpl userDao = new UserDaoImpl();

    public User findById(int id){
        return userDao.read(id);
    }

}
