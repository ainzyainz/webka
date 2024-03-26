package services.userservice;

import DAO.classes.UserDaoImpl;
import DTO.UserDTO;
import entities.User;
import utils.mapper.UserDTOMapper;

import java.util.List;

public class UserBehavior {

    private static final UserBehavior INSTANCE = new UserBehavior();
    private final UserDaoImpl userDao = new UserDaoImpl();
    private final UserDTOMapper userDTOMapper = new UserDTOMapper();

    private UserBehavior() {
    }

    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getEmail().isEmpty() || userDTO.getPassword().isEmpty()) {
            return null;
        }
            return userDTOMapper.apply(userDao.create(userDTOMapper.apply(userDTO)));
    }

    public UserDTO findById(int id) {
        return userDTOMapper.apply(userDao.read(id));
    }

    public List<User> getRoleByLoginAndPassword(String email, String password) {
        return userDao.getRoleByLoginAndPassword(email, password);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            return null;
        }
        return userDTOMapper.apply(user);
    }

    public UserDTO getUserByPassword(String password) {
        return userDTOMapper.apply(userDao.getUserByPassword(password));
    }

    public UserDTO update(int id, UserDTO object) {
        return userDTOMapper.apply(userDao.update(id, userDTOMapper.apply(object)));
    }

    public boolean alreadyExists(UserDTO userDTO) {
        if (getUserByEmail(userDTO.getEmail()) != null) {
            return true;
        }
        return false;
    }

    public static UserBehavior getINSTANCE() {
        return INSTANCE;
    }
}
