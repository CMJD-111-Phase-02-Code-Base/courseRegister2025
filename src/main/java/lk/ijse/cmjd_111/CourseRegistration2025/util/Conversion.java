package lk.ijse.cmjd_111.CourseRegistration2025.util;

import lk.ijse.cmjd_111.CourseRegistration2025.dao.LecturerDao;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.CourseEntity;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.LecturerEntity;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper modelMapper;
    private final LecturerDao lecturerDao;

    //Student
    public UserDTO toStudentDTO(StudentEntity student){
        return modelMapper.map(student,UserDTO.class);
    }
    public StudentEntity toStudentEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,StudentEntity.class);
    }
    public List<UserDTO> toStudentDTOList(List<StudentEntity> students){
        return modelMapper.map(students,new TypeToken<List<UserDTO>>(){}.getType());
    }
    //Lecturer
    public UserDTO toLecturerDTO(LecturerEntity lecturer){
        return modelMapper.map(lecturer,UserDTO.class);
    }
    public LecturerEntity toLecturerEntity(UserDTO lecturerDTO){
        return modelMapper.map(lecturerDTO,LecturerEntity.class);
    }
    public List<UserDTO> toLecturerDTOList(List<LecturerEntity> lecturers){
        return modelMapper.map(lecturers,new TypeToken<List<UserDTO>>(){}.getType());
    }
    //Admin

    //Course
    public CourseDTO toCourseDTO(CourseEntity course){
        var courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setCredit(course.getCredit());
        courseDTO.setStartTime(course.getStartTime());
        courseDTO.setEndTime(course.getEndTime());
        if(course.getLecturer() !=null){
            courseDTO.setLecturer(course.getLecturer().getId());
        }
        return courseDTO;
    }

    public CourseEntity toCourseEntity(CourseDTO courseDTO){
        var courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseDTO.getCourseId());
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setCourseCode(courseDTO.getCourseCode());
        courseEntity.setDescription(courseDTO.getDescription());
        courseEntity.setCredit(courseDTO.getCredit());
        courseEntity.setStartTime(courseDTO.getStartTime());
        courseEntity.setEndTime(courseDTO.getEndTime());
        LecturerEntity lecturer= lecturerDao.findById(courseDTO.getCourseId())
                .orElseThrow(()-> new RuntimeException("Lecturer Not Found"));
        courseEntity.setLecturer(lecturer);
        return courseEntity;

    }
}
