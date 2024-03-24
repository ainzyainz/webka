package DTO;

import entities.Student;
import lombok.*;
import utils.roles.Roles;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;

    private String password;

    private String login;

    private Roles role;

    private Student student;
}
