package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.AdminService;
import lk.ijse.cmjd_111.CourseRegistration2025.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveAdmin(@RequestBody UserDTO admin){
        return new ResponseEntity<>(admin,HttpStatus.CREATED);
    }
    @GetMapping(value = "{lecturerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedAdmin(@PathVariable String lecturerID){
        if(lecturerID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(adminService.getSelectedAdmin(lecturerID),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllAdmins(){
        return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
    }
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLecturer(@RequestParam String lecturerId,@RequestBody UserDTO lecturerUpdateData){
        System.out.println("Lecturer id "+lecturerId);
        System.out.println(lecturerUpdateData);
    }
    @DeleteMapping
    public void deleteAdmins(@RequestHeader("X-lecturerId") String lecturerID){
        System.out.println("ID to be deleted: "+lecturerID);
    }
}
