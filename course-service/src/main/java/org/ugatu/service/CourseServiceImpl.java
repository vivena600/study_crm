package org.ugatu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugatu.dto.CreateCourseDto;
import org.ugatu.dto.FullCourseDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.mapper.CourseMapper;
import org.ugatu.model.Course;
import org.ugatu.repository.CourseRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public FullCourseDto createCourse(CreateCourseDto dto) {
        log.info("Create course: {}", dto.toString());

        Course course = courseMapper.toNewEntity(dto);
        course.setCreatedAt(LocalDateTime.now());
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FullCourseDto> getCourses() {
        log.info("Get courses");
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FullCourseDto getCourseById(UUID id) {
        log.info("Get course: {}", id);
        Course course = findCourseById(id);
        return courseMapper.toDto(course);
    }

    @Override
    public FullCourseDto updateCourse(UUID id, CreateCourseDto dto) {
        log.info("Update course with id {}", id);
        Course course = findCourseById(id);

        Optional.ofNullable(dto.getTitle()).ifPresent(course::setTitle);
        Optional.ofNullable(dto.getDescription()).ifPresent(course::setDescription);
        Optional.ofNullable(dto.getStatus()).ifPresent(course::setStatus);
        Optional.ofNullable(dto.getMaxStudents()).ifPresent(course::setMaxStudents);
        Optional.ofNullable(dto.getStartTime()).ifPresent(course::setStartTime);
        Optional.ofNullable(dto.getEndTime()).ifPresent(course::setEndTime);

        return courseMapper.toDto(courseRepository.save(course));
    }

    private Course findCourseById(UUID id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }
}
