package org.ugatu.service;

import org.ugatu.dto.ShortCourseDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    void assignTeacher(UUID courseId, UUID teacherId);

    List<ShortCourseDto> getCoursesByTeacher(UUID teacherId);
}
