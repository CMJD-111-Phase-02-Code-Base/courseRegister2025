package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "lecturer")
public class LecturerController {
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveLecturer(@RequestBody UserDTO lecturer){
        System.out.println(lecturer);
        return new ResponseEntity<>(lecturer,HttpStatus.CREATED);
    }
    @GetMapping(value = "{lecturerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String lecturerID){
        // send student details
        System.out.println("Path Variable is: "+lecturerID);
        var student01 = new UserDTO("LECT01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.LECTURER);
        if(lecturerID == null || !lecturerID.equals(student01.getUserId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student01,HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllLecturers(){
        List<UserDTO> lecturerList = Arrays.asList(
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

        return new ResponseEntity<>(lecturerList, HttpStatus.OK);
    }
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLecturer(@RequestParam String lecturerId,@RequestBody UserDTO lecturerUpdateData){
        System.out.println("Lecturer id "+lecturerId);
        System.out.println(lecturerUpdateData);
    }
    @DeleteMapping
    public void deleteLecturer(@RequestHeader("X-lecturerId") String lecturerID){
        System.out.println("ID to be deleted: "+lecturerID);
    }
}
