package org.ugatu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.ugatu.client.TeacherClient;
import org.ugatu.dto.ShortCourseDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.mapper.CourseMapper;
import org.ugatu.model.CourseTeacher;
import org.ugatu.repository.CourseRepository;
import org.ugatu.repository.CourseTeacherRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final CourseTeacherRepository courseTeacherRepository;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final TeacherClient teacherClient;

    @Override
    public void assignTeacher(UUID courseId, UUID teacherId) {
        log.info("Assigning teacher {} to course {}", teacherId, courseId);
        checkCourses(courseId);
        checkTeachers(teacherId);

        // Проверка дублирования
        if (courseTeacherRepository.existsByCourseIdAndTeacherId(courseId, teacherId)) {
            log.warn("Teacher {} is already assigned to course {}", teacherId, courseId);
        }

        CourseTeacher map = CourseTeacher.builder()
                .teacherId(teacherId)
                .courseId(courseId)
                .build();
        courseTeacherRepository.save(map);

        log.info("Teacher success assigned to course {}", courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShortCourseDto> getCoursesByTeacher(UUID teacherId) {
        checkTeachers(teacherId);

        List<UUID> courseIds = courseTeacherRepository.findByTeacherId(teacherId)
                .stream()
                .map(CourseTeacher::getCourseId)
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

    private void checkTeachers(UUID teacherId) {
        // Проверка существования преподавателя через teacher-service
        try {
            teacherClient.checkTeacherExists(teacherId);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("Teacher with ID " + teacherId + " not found in teacher-service");
        } catch (Exception ex) {
            log.error("Error calling teacher-service for teacher ID: {}", teacherId, ex);
            throw new RuntimeException("Failed to validate teacher existence", ex);
        }
    }
}
