package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @PostMapping
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO studentData){
        System.out.println(studentData);
        return new ResponseEntity<>(studentData,HttpStatus.CREATED);
    }
    @GetMapping("{studentID}")
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentID){
        // send student details
        System.out.println("Path Variable is: "+studentID);
        var student01 = new UserDTO("STU01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.STUDENT);
        if(studentID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student01,HttpStatus.OK);
    }
}
