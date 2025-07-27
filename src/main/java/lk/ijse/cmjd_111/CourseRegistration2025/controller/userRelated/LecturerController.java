package lk.ijse.cmjd_111.CourseRegistration2025.controller.userRelated;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lecturer")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveLecturer(@RequestBody UserDTO lecturer){
        System.out.println(lecturer);
        return new ResponseEntity<>(lecturer,HttpStatus.CREATED);
    }
    @GetMapping(value = "{lecturerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String lecturerID){
        if(lecturerID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(lecturerService.getSelectedLecturer(lecturerID),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllLecturers(){
        return new ResponseEntity<>(lecturerService.getAllLecturers(), HttpStatus.OK);
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
