package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "course")
@RequiredArgsConstructor
public  class CourseController {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCourse(@RequestBody CourseDTO courseDTO) {
        //
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getSelectedCourse(@PathVariable String courseId) {
        if (courseId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(userService.getSelectedUser(userId), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> getAllCourses() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCourse(@RequestParam String courseId,
                                           @RequestBody CourseDTO toBeUpdatedCourseData) {
        try {
            userService.updateUser(userId, toBeUpdatedData);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{courseId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String courseId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
