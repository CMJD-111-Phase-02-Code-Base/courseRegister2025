package lk.ijse.cmjd_111.CourseRegistration2025.util;

import lk.ijse.cmjd_111.CourseRegistration2025.dao.CourseDao;
import lk.ijse.cmjd_111.CourseRegistration2025.dao.LecturerDao;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.CourseEntity;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.CourseMaterialEntity;
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
    private final CourseDao courseDao;

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
        LecturerEntity lecturer= lecturerDao.findById(courseDTO.getLecturer())
                .orElseThrow(()-> new RuntimeException("Lecturer Not Found"));
        courseEntity.setLecturer(lecturer);
        return courseEntity;
    }
    public List<CourseDTO> toCourseDTOList(List<CourseEntity> courses){
        return courses.stream().map(this::toCourseDTO).toList();
    }

    // Course Material
    public CourseMaterialDTO toCourseMaterialDTO(CourseMaterialEntity courseMaterialEntity) {
        CourseMaterialDTO dto = new CourseMaterialDTO();
        dto.setMaterialId(courseMaterialEntity.getMaterialId());
        dto.setFileName(courseMaterialEntity.getFileName());
        dto.setMaterialType(courseMaterialEntity.getMaterialType());
        dto.setMaterial(courseMaterialEntity.getMaterial());
        dto.setUploadAt(courseMaterialEntity.getUploadAt());
        if (courseMaterialEntity.getCourse() != null) {
            dto.setCourseId(courseMaterialEntity.getCourse().getCourseId());
        }
        return dto;

    }
    public CourseMaterialEntity toCourseMaterialEntity(CourseMaterialDTO courseMaterialDTO) {
        CourseMaterialEntity entity = new CourseMaterialEntity();
        entity.setMaterialId(courseMaterialDTO.getMaterialId());
        entity.setFileName(courseMaterialDTO.getFileName());
        entity.setMaterialType(courseMaterialDTO.getMaterialType());
        entity.setMaterial(courseMaterialDTO.getMaterial());
        entity.setUploadAt(courseMaterialDTO.getUploadAt());

        if (courseMaterialDTO.getCourseId() != null) {
            CourseEntity selectedCourse = courseDao.findById(courseMaterialDTO.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course Material not found with id: " + courseMaterialDTO.getCourseId()));
            entity.setCourse(selectedCourse);
        }

        return entity;
    }
    public List<CourseMaterialDTO> toCourseMaterialDTOList(List<CourseMaterialEntity> entities) {
        return entities.stream().map(this::toCourseMaterialDTO).toList();
    }

    public List<CourseMaterialEntity> toCourseMaterialEntityList(List<CourseMaterialDTO> dtos) {
        return dtos.stream().map(this::toCourseMaterialEntity).toList();
    }
}
