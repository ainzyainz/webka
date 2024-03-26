package services.studentservice;

import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import DTO.StudentDTO;

import entities.Student;
import entities.User;
import services.userservice.UserBehavior;
import utils.mapper.StudentDTOMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static utils.constant.ConstantsContainer.USER_IS_NULL;

public class Behavior {

    private static final Behavior INSTANCE = new Behavior();
    private final StudentDTOMapper studentDTOMapper = new StudentDTOMapper();
    private final StudentDAO studentDAO = new StudentDAOImpl();
    private final Logger LOGGER = Logger.getLogger(Behavior.class.getName());
    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();

    private Behavior() {
    }


    public StudentDTO getStudentOfLoginAndPassword(String email, String password) {
        List<User> userDTOS = userBehavior.getRoleByLoginAndPassword(email, password);

        if (userDTOS == null) {
            LOGGER.log(Level.INFO, USER_IS_NULL);
            return null;
        }

        User userDTO = userDTOS.get(0);
        if (userDTO.getStudent() == null) {
            userDTO.setStudent(studentDAO.findByUserId(userDTO.getId()));
        }
        return studentDTOMapper.apply(userDTO.getStudent());
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {

        if (studentDTO.getUserDTO().getEmail().isEmpty() || studentDTO.getName().isEmpty() || studentDTO.getSurname().isEmpty()) {
            return null;
        }
        if (studentDTO.getAge() <= 0) {
            studentDTO.setAge(-1);
        }
        studentDAO.create(studentDTOMapper.apply(studentDTO));
        return studentDTO;
    }

    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        Student result = studentDTOMapper.apply(studentDTO);
        return studentDTOMapper.apply(studentDAO.update(id, result));
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
