package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceIMPL implements CourseService {
    @Override
    public void saveCourse(CourseDTO courseDTO) {

    }

    @Override
    public void deleteCourse(String courseId) throws Exception {

    }

    @Override
    public void updateCourse(String courseId, CourseDTO toBeUpdatedCourse) throws Exception {

    }

    @Override
    public CourseDTO getSelectedCourse(String courseId) throws Exception {
        return null;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return List.of();
    }
}
