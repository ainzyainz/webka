package services;

import DAO.classes.StudentDAOImpl;
import DTO.StudentDTO;
import entities.Student;
import utils.StudentDTOMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Behavior {
    private StudentDTOMapper studentDTOMapper = new StudentDTOMapper();
    private StudentDAOImpl studentDAO = new StudentDAOImpl();

    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents()
                .stream()
                .map(studentDTOMapper)
                .collect(Collectors.toList());
    }

    public StudentDTO createStudent(String name, String surname, String address, String age, String mark, String email) {
        if (name.isEmpty() || surname.isEmpty() || address.isEmpty() || age.isEmpty() || mark.isEmpty() || email.isEmpty()) {
            System.out.println("you didn't write all the values");
            return null;
        }
        int intAge = 0;
        int intMark = 0;
        try {
            intAge = Integer.parseInt(age);
            intMark = Integer.parseInt(mark);
        } catch (NumberFormatException e) {
            System.out.println("age and mark must be numbers");
            return null;
        }
        StudentDTO studentDTO = StudentDTO.builder()
                .name(name)
                .surname(surname)
                .address(address)
                .age(intAge)
                .mark(intMark)
                .build();
        studentDAO.create(studentDTOMapper.apply(studentDTO, email));
        return studentDTO;
    }

    public void updateStudent(int id, StudentDTO studentDTO) {
        /*Student x = studentDTOMapper.apply(studentDTO);
        studentDAO.update(id,x);*/
    }

    public int deleteStudent(String id) {
        int intId = 0;
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("failed");
            return -1;
        }
        studentDAO.delete(intId);
        return 1;
    }
    public int getNoOfRecords(){
        return studentDAO.getNoOfRecords();
    }
    public List<StudentDTO> readStudentLimited(int x, int y){
        return studentDAO.getLimited(x,y).stream().map(studentDTOMapper).collect(Collectors.toList());
    }

    public List<StudentDTO> readStudent(String search) {
        List<StudentDTO> result = studentDAO.getSearch(search).stream().map(studentDTOMapper).collect(Collectors.toList());
        return result;
    }
}
