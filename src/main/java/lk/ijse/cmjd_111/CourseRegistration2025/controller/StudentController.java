package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.StudentService;
import lk.ijse.cmjd_111.CourseRegistration2025.service.impl.StudentServiceIMPL;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO studentData){
        var studentServiceIMPL = new StudentServiceIMPL();
        var studentDetails = studentServiceIMPL.saveStudent(studentData);
        return new ResponseEntity<>(studentDetails,HttpStatus.CREATED);
    }
    @GetMapping(value = "{studentID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentID){
        if(studentID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(studentService.getSelectedStudent(studentID),
                    HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllStudents(){
        List<UserDTO> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
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
