package org.ugatu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugatu.dto.CreateLessonDto;
import org.ugatu.dto.FullLessonDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.mapper.LessonMapper;
import org.ugatu.model.Lesson;
import org.ugatu.repository.CourseRepository;
import org.ugatu.repository.LessonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public FullLessonDto createLesson(UUID courseId, CreateLessonDto dto, UUID teacherId) {
        checkCourse(courseId);
        Lesson lesson = lessonMapper.toEntity(dto, courseId);
        lesson.setTeacherId(teacherId);
        return lessonMapper.toDto(lessonRepository.save(lesson));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FullLessonDto> getSchedule(UUID courseId) {
        checkCourse(courseId);

        List<Lesson> lessons = lessonRepository.findByCourseIdOrderByStartTime(courseId);

        return lessons.stream()
                .map(lessonMapper::toDto)
                .toList();
    }

    private void checkCourse(UUID courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new NotFoundException("Course with ID " + courseId + " not found");
        }
    }
}
