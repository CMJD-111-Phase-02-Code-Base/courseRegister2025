package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;

import java.util.List;

public interface LecturerService {
    UserDTO saveLecturer(UserDTO student);
    void deleteLecturer(String studentId);
    void updateLecturer(String studentId,UserDTO student);
    UserDTO getSelectedLecturer(String studentId) throws Exception;
    List<UserDTO> getAllLecturers();
}
