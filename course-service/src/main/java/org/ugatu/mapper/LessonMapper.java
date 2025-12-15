package org.ugatu.mapper;

import org.springframework.stereotype.Component;
import org.ugatu.dto.CreateLessonDto;
import org.ugatu.dto.FullLessonDto;
import org.ugatu.model.Lesson;

import java.util.UUID;

@Component
public class LessonMapper {

    public Lesson toEntity(CreateLessonDto dto, UUID courseId) {
        return Lesson.builder()
                .courseId(courseId)
                .title(dto.getTitle())
                .textLesson(dto.getTextLesson())
                .lessonType(dto.getLessonType())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();
    }

    public FullLessonDto toDto(Lesson lesson) {
        return FullLessonDto.builder()
                .id(lesson.getId())
                .courseId(lesson.getCourseId())
                .teacherId(lesson.getTeacherId())
                .title(lesson.getTitle())
                .textLesson(lesson.getTextLesson())
                .lessonType(lesson.getLessonType())
                .startTime(lesson.getStartTime())
                .endTime(lesson.getEndTime())
                .build();
    }
}
