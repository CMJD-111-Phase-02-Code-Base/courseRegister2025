package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;

import java.util.List;

public interface StudentService {
    void saveStudent(UserDTO student);
    void deleteStudent(String studentId);
    void updateStudent(String studentId,UserDTO student);
    UserDTO getSelectedStudent(String studentId);
    List<UserDTO> getAllStudents();
}
