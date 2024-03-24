package DTO;

import entities.Student;
import lombok.*;
import utils.roles.Roles;

@Builder
@Data
@ToString(exclude = "student")
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;

    private String password;

    private String email;

    private Roles role;

    private StudentDTO student;
}
