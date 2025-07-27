package lk.ijse.cmjd_111.CourseRegistration2025.util;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
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
}
