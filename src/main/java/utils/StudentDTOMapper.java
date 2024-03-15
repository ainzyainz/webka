package utils;

import DTO.StudentDTO;
import entities.Student;

import java.util.function.Function;

public class StudentDTOMapper implements Function<Student, StudentDTO> {
    @Override
    public StudentDTO apply(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getAddress(),
                student.getAge(),
                student.getMark()
        );
    }

    public Student apply(StudentDTO studentDTO,String email) {
        return new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getSurname(),
                studentDTO.getAddress(),
                studentDTO.getAge(),
                studentDTO.getMark(),
                email
        );
    }
}
