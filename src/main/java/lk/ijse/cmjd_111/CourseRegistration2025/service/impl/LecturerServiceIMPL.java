package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.LecturerService;
import lk.ijse.cmjd_111.CourseRegistration2025.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LecturerServiceIMPL implements LecturerService {

    @Override
    public UserDTO saveLecturer(UserDTO lecturer) {
        return null;
    }

    @Override
    public void deleteLecturer(String lecturerId) {

    }

    @Override
    public void updateLecturer(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public UserDTO getSelectedLecturer(String lecturerId) throws Exception {
        var selectedLecturer = new UserDTO("LECT01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.LECTURER);
        if(lecturerId.equals(selectedLecturer.getUserId())){
            return selectedLecturer;
        }
        throw new Exception("Invalid Lecturer Id");

    }

    @Override
    public List<UserDTO> getAllLecturers() {
        return Arrays.asList(
                new UserDTO("LECT02", "Anura",
                        "Jayalath", "anura.j@mail.com",
                        "Park Avenue", "Colombo 03",
                        "Colombo", "Colombo",
                        "lect456", Role.LECTURER),

                new UserDTO("LECT03", "Sanduni",
                        "Ranasinghe", "sanduni.r@mail.com",
                        "Station Road", "Kurunegala Town",
                        "Kurunegala", "Kurunegala",
                        "lect789", Role.LECTURER),

                new UserDTO("LECT04", "Chandana",
                        "Rajapaksha", "chandana.r@mail.com",
                        "Main Street", "Jaffna East",
                        "Jaffna", "Jaffna",
                        "jaffna123", Role.LECTURER),

                new UserDTO("LECT05", "Harshani",
                        "Dissanayake", "harshani.d@mail.com",
                        "College Road", "Anuradhapura North",
                        "Anuradhapura", "Anuradhapura",
                        "anu456", Role.LECTURER),

                new UserDTO("LECT06", "Niroshan",
                        "Edirisinghe", "niroshan.e@mail.com",
                        "River Side", "Badulla Central",
                        "Badulla", "Badulla",
                        "badulla321", Role.LECTURER)

        );
    }
}
