package utils.mapper;

import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;

import java.util.function.Function;

public class UserMapper  implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getStudent()
        );
    }
    public User apply(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getLogin(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getStudent()
        );
    }
}
