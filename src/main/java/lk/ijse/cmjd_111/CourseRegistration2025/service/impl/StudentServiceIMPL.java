package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceIMPL implements StudentService {
    @Override
    public UserDTO saveStudent(UserDTO student) {
      return null;
    }

    @Override
    public void deleteStudent(String studentId) {

    }

    @Override
    public void updateStudent(String studentId, UserDTO student) {

    }

    @Override
    public UserDTO getSelectedStudent(String studentId) throws Exception {
        var selectedStudent = new UserDTO("STU01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.STUDENT);
        if(studentId.equals(selectedStudent.getUserId())){
           return selectedStudent;
        }
        throw new Exception("Student Not Found");
    }

    @Override
    public List<UserDTO> getAllStudents() {
        return List.of();
    }
}
