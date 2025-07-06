package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @PostMapping
    public String saveStudent(){
        return "Student Registration Successfully!";
    }
}
