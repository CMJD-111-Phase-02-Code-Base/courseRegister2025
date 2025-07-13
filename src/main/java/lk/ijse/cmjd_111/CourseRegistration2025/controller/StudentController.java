package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO studentData){
        System.out.println(studentData);
        return new ResponseEntity<>(studentData,HttpStatus.CREATED);
    }
    @GetMapping(value = "{studentID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentID){
        // send student details
        System.out.println("Path Variable is: "+studentID);
        var student01 = new UserDTO("STU01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.STUDENT);
        if(studentID == null || !studentID.equals(student01.getUserId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student01,HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllStudents(){
        List<UserDTO> studentList = Arrays.asList(
                new UserDTO("STU02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.STUDENT),

                new UserDTO("STU03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.STUDENT),

                new UserDTO("STU04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.STUDENT),

                new UserDTO("STU05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.STUDENT),

                new UserDTO("STU06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.STUDENT)
        );

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestParam String studentId,@RequestBody UserDTO studentUpdateData){
        System.out.println("Student id "+studentId);
        System.out.println(studentUpdateData);
    }
    @DeleteMapping
    public void deleteStudent(@RequestHeader("X-studentId") String studentID){
        System.out.println("ID to be deleted: "+studentID);
    }
}
