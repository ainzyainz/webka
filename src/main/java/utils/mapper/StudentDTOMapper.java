package utils.mapper;

import DTO.CountryDTO;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Country;
import entities.Student;
import entities.User;

import java.util.function.Function;

public class StudentDTOMapper implements Function<Student, StudentDTO> {

    private final UserDTOMapper userDTOMapper = new UserDTOMapper();
    private final CountryDTOMapper countryDTOMapper = new CountryDTOMapper();

    @Override
    public StudentDTO apply(Student student) {
        UserDTO userDTO = userDTOMapper.apply(student.getUser());
        CountryDTO countryDTO = countryDTOMapper.apply(student.getCountry());
        return StudentDTO.builder()
                .id(student.getId())
                .userDTO(userDTO)
                .name(student.getName())
                .surname(student.getSurname())
                .address(student.getAddress())
                .age(student.getAge())
                .mark(student.getMark())
                .countryDTO(countryDTO)
                .build();
    }

    public Student apply(StudentDTO studentDTO) {
        User userDTO = userDTOMapper.apply(studentDTO.getUserDTO());
        Country country = countryDTOMapper.apply(studentDTO.getCountryDTO());
        return Student.builder()
                .user(userDTO)
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .address(studentDTO.getAddress())
                .age(studentDTO.getAge())
                .mark(studentDTO.getMark())
                .country(country)
                .build();
    }

}
