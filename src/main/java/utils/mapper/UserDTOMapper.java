package utils.mapper;

import DTO.StudentDTO;
import DTO.UserDTO;
import entities.User;

import java.util.function.Function;

public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .role(user.getRole())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    public User apply(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .role(userDTO.getRole())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
