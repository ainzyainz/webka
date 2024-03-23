package services.studentservice;

import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import DTO.StudentDTO;
import entities.Student;
import utils.mapper.StudentDTOMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static utils.constant.ConstantsContainer.*;

public class Behavior {

    private static final Behavior INSTANCE = new Behavior();
    private final StudentDTOMapper studentDTOMapper = new StudentDTOMapper();
    private final StudentDAO studentDAO = new StudentDAOImpl();
    private final Logger LOGGER = Logger.getLogger(Behavior.class.getName());

    private Behavior() {
    }

    public StudentDTO createStudent(String name, String surname, String address, String age, String mark, String email) {

        if (name.isEmpty() && surname.isEmpty() && age.isEmpty()) {
            return null;
        }

        if (name.isEmpty()) {
            name = EMPTY_VALUE;
        }
        if (surname.isEmpty()) {
            surname = EMPTY_VALUE;
        }
        if (address.isEmpty()) {
            address = EMPTY_VALUE;
        }
        if (email.isEmpty()) {
            email = EMPTY_VALUE;
        }
        if (age.isEmpty()) {
            age = STRING_NULL;
        }
        if (mark.isEmpty()) {
            mark = MARK_IS_NULL;
        }

        int intAge;
        int intMark;
        try {
            intAge = Integer.parseInt(age);
            intMark = Integer.parseInt(mark);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, INCORRECT_TYPE);
            return null;
        }
        StudentDTO studentDTO = StudentDTO.builder()
                .name(name)
                .surname(surname)
                .address(address)
                .age(intAge)
                .mark(intMark)
                .build();

        studentDAO.create(studentDTOMapper.apply(studentDTO));
        return studentDTO;
    }

    public void updateStudent(int id, StudentDTO studentDTO) {
        Student result = studentDTOMapper.apply(studentDTO);
        studentDAO.update(id, result);
    }

    public int deleteStudent(String id) {
        int intId;
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return -1;
        }
        studentDAO.delete(intId);

        return intId;
    }

    public int getNoOfRecords() {
        return studentDAO.getNoOfRecords();
    }

    public List<StudentDTO> readStudentLimited(int from, int to) {
        return studentDAO.getLimited(from, to).stream().map(studentDTOMapper).collect(Collectors.toList());
    }

    public List<StudentDTO> readStudents(String search) {
        return studentDAO.getSearch(search).stream().map(studentDTOMapper).collect(Collectors.toList());
    }

    public StudentDTO readById(int id) {
        return studentDTOMapper.apply(studentDAO.read(id));
    }

    public static Behavior getINSTANCE() {
        return INSTANCE;
    }
}
