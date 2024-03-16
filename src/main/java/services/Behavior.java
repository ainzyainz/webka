package services;

import DAO.classes.StudentDAOImpl;
import DTO.StudentDTO;
import utils.StudentDTOMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Behavior {
    private StudentDTOMapper studentDTOMapper = new StudentDTOMapper();
    private StudentDAOImpl studentDAO = new StudentDAOImpl();

    public List<StudentDTO> getAllStudents(){
        return studentDAO.getAllStudents()
                .stream()
                .map(studentDTOMapper)
                .collect(Collectors.toList());
    }

    public StudentDTO createStudent(String name, String surname, String address, String age, String mark,String email){
        if (name.isEmpty()||surname.isEmpty()||address.isEmpty()||age.isEmpty()||mark.isEmpty()||email.isEmpty()){
            System.out.println("you didn't write all the values");
            return null;
        }
        int intAge = 0;
        int intMark = 0;
        try{
            intAge = Integer.parseInt(age);
            intMark = Integer.parseInt(mark);
        }catch(NumberFormatException e){
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
        studentDAO.create(studentDTOMapper.apply(studentDTO,email));
        return studentDTO;
    }

    public void updateStudent(int id, StudentDTO studentDTO){
        /*Student x = studentDTOMapper.apply(studentDTO);
        studentDAO.update(id,x);*/
    }
    public int deleteStudent(String id){
        int intId = 0;
        try{
            intId=Integer.parseInt(id);
        }catch (NumberFormatException e){
            System.out.println("failed");
            return -1;
        }
        studentDAO.delete(intId);
        return 1;
    }
    public List<StudentDTO> readStudent(String search) {
        List<StudentDTO> result = new ArrayList<>();
            studentDAO.readByName(search)
                    .stream()
                    .map(studentDTOMapper)
                    .forEach(q -> result.add(q));

            studentDAO.readByAddress(search)
                    .stream()
                    .map(studentDTOMapper)
                    .forEach(q -> result.add(q));

        try {
            int intAge = Integer.parseInt(search);
            int intMark = Integer.parseInt(search);
            studentDAO.readByAge(intAge).stream().map(studentDTOMapper).forEach(q -> result.add(q));
            studentDAO.readByMark(intMark).stream().map(studentDTOMapper).forEach(q -> result.add(q));
        } catch (NumberFormatException e) {
            //search is not a number
            return result;
        }
        return result;
    }




}
