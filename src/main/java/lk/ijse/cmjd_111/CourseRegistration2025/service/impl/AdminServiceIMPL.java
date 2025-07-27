package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceIMPL implements GenericService<UserDTO> {

    @Override
    public void saveUser(UserDTO user) {

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, UserDTO user) {

    }

    @Override
    public UserDTO getSelectedUser(String userId) throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
