package org.ugatu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.ugatu.client.StudentClient;
import org.ugatu.dto.ShortCourseDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.mapper.CourseMapper;
import org.ugatu.model.CourseStudent;
import org.ugatu.repository.CourseRepository;
import org.ugatu.repository.CourseStudentRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final CourseStudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final StudentClient studentClient;

    @Override
    public void assignStudent(UUID courseId, UUID studentId) {
        log.info("Assign student to courseId:{} studentId:{}", courseId, studentId);
        checkCourses(courseId);
        checkStudent(studentId);

        if (studentRepository.existsByCourseIdAndStudentId(courseId, studentId)) {
            log.warn("Student already assigned to courseId:{} studentId:{}", courseId, studentId);
        }

        CourseStudent courseStudent = CourseStudent.builder()
                .courseId(courseId)
                .studentId(studentId)
                .build();
        studentRepository.save(courseStudent);

        log.info("Assign student to courseId:{} studentId:{}", courseId, studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShortCourseDto> getCoursesByStudent(UUID studentId) {
        checkStudent(studentId);

        List<UUID> courseIds = studentRepository.findByStudentId(studentId).stream()
                .map(CourseStudent::getCourseId)
                .toList();
        return courseRepository.findAllById(courseIds).stream()
                .map(courseMapper::toShortDto)
                .toList();
    }

    private void checkCourses(UUID courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new NotFoundException("Course with ID " + courseId + " not found");
        }
    }

    private void checkStudent(UUID studentId) {
        try {
            studentClient.checkStudentExists(studentId);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("Teacher with ID " + studentId + " not found in teacher-service");
        } catch (Exception ex) {
            log.error("Error calling teacher-service for teacher ID: {}", studentId, ex);
            throw new RuntimeException("Failed to validate teacher existence", ex);
        }
    }
}
