package utils.mapper;

import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;

import java.util.function.Function;

public class StudentDTOMapper implements Function<Student, StudentDTO> {
    private UserDTOMapper userDTOMapper = new UserDTOMapper();
    @Override
    public StudentDTO apply(Student student) {
        UserDTO userDTO = userDTOMapper.apply(student.getUser());
        return StudentDTO.builder()
                .id(student.getId())
                .userDTO(userDTO)
                .name(student.getName())
                .surname(student.getSurname())
                .address(student.getAddress())
                .age(student.getAge())
                .mark(student.getMark())
                .build();
    }

    public Student apply(StudentDTO studentDTO) {
        User userDTO = userDTOMapper.apply(studentDTO.getUserDTO());
        return Student.builder()
                .user(userDTO)
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .address(studentDTO.getAddress())
                .age(studentDTO.getAge())
                .mark(studentDTO.getMark())
                .build();
    }

}
