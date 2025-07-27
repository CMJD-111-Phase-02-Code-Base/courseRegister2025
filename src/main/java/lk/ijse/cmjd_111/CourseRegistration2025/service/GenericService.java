package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;

import java.util.List;

public interface GenericService<T> {
    void saveUser(T user);
    void deleteUser(String userId);
    void updateUser(String userId,T user);
    T getSelectedUser(String userId) throws Exception;
    List<T> getAllUsers();
}
