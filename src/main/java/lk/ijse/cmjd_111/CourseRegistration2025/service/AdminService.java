package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;

import java.util.List;

public interface AdminService {
    UserDTO saveAdmin(UserDTO admin);
    void deleteAdmin(String adminId);
    void updateAdmin(String adminId,UserDTO admin);
    UserDTO getSelectedAdmin(String adminId) throws Exception;
    List<UserDTO> getAllAdmins();
}
