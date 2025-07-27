package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;
import lk.ijse.cmjd_111.CourseRegistration2025.dao.StudentDao;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.entity.StudentEntity;
import lk.ijse.cmjd_111.CourseRegistration2025.service.GenericService;
import lk.ijse.cmjd_111.CourseRegistration2025.util.Conversion;
import lk.ijse.cmjd_111.CourseRegistration2025.util.IDGen;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceIMPL implements GenericService<UserDTO> {
   private final StudentDao studentDao;
   private final Conversion conversion;

    @Override
    public void saveUser(UserDTO user) {
        var studentEntity = conversion.toStudentEntity(user);
        studentEntity.setId(IDGen.generateStudentID());
        studentDao.save(studentEntity);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, UserDTO user) {

    }

    @Override
    public UserDTO getSelectedUser(String studentId) throws Exception {
        Optional<StudentEntity> foundStudent =
                studentDao.findById(studentId);
        if(!foundStudent.isPresent()){
            throw new Exception("Student not found");
        }
        return conversion.toStudentDTO(studentDao.getReferenceById(studentId));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return conversion.toStudentDTOList(studentDao.findAll());
    }
}
