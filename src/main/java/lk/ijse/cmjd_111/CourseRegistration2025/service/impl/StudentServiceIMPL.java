package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.StudentService;

import java.util.List;

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
    public UserDTO getSelectedStudent(String studentId) {
        var student01 = new UserDTO("STU01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.STUDENT);
        return student01;
    }

    @Override
    public List<UserDTO> getAllStudents() {
        return List.of();
    }
}
