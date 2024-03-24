package services.studentservice;

import DAO.classes.StudentDAOImpl;
import DAO.interfaces.StudentDAO;
import DTO.StudentDTO;
import DTO.UserDTO;
import entities.Student;
import entities.User;
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
    private final UserBehavior userBehavior = UserBehavior.getINSTANCE();
    private Behavior() {
    }


    public StudentDTO getStudentOfLoginAndPassword(String email, String password){
        List<User> userDTOS = userBehavior.getRoleByLoginAndPassword(email,password);
        if (userDTOS==null){
            System.out.println("userdtos is null");
            return null;
        }
        StudentDTO userStudent = studentDTOMapper.apply(userDTOS.get(0).getStudent());
        System.out.println(userStudent);
        ;return userStudent;
    }


    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents()
                .stream()
                .map(studentDTOMapper)
                .collect(Collectors.toList());
    }
    public StudentDTO createStudent(StudentDTO studentDTO) {

        if (studentDTO.getUserDTO().getEmail().isEmpty() || studentDTO.getName().isEmpty() || studentDTO.getSurname().isEmpty()) {
            return null;
        }
        if (studentDTO.getAge()<=0) {
            studentDTO.setAge(-1);
        }
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
