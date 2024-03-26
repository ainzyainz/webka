package services.studentservice;

import DAO.classes.UserDaoImpl;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.User;
import utils.mapper.UserDTOMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserBehavior {

    private static final UserBehavior INSTANCE = new UserBehavior();
    private UserDaoImpl userDao = new UserDaoImpl();
    private UserDTOMapper userDTOMapper = new UserDTOMapper();
    private UserBehavior() {
    }
    public UserDTO findById(int id){
        return userDTOMapper.apply(userDao.read(id));
    }
    public List<User> getRoleByLoginAndPassword(String email, String password){
            return userDao.getRoleByLoginAndPassword(email, password);
    }
    public UserDTO getUserByEmail(String email){
        return userDTOMapper.apply(userDao.getUserByEmail(email));
    }
    public UserDTO getUserByPassword(String password){
        return userDTOMapper.apply(userDao.getUserByPassword(password));
    }
    public UserDTO update(int id, UserDTO object){
        return userDTOMapper.apply(userDao.update(id,userDTOMapper.apply(object)));
    }
    public boolean alreadyExists(UserDTO userDTO){
        if (getUserByEmail(userDTO.getEmail())!=null){
            return true;
        }
        return false;
    }
    public static UserBehavior getINSTANCE() {
        return INSTANCE;
    }

}
