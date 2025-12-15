package org.ugatu.service;


import org.ugatu.dto.CreateLessonDto;
import org.ugatu.dto.FullLessonDto;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    FullLessonDto createLesson(UUID courseId, CreateLessonDto dto, UUID teacherId);

    List<FullLessonDto> getSchedule(UUID courseId);
}
