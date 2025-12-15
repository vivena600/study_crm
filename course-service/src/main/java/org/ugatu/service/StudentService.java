package org.ugatu.service;

import org.ugatu.dto.ShortCourseDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void assignStudent(UUID courseId, UUID studentId);

    List<ShortCourseDto> getCoursesByStudent(UUID studentId);
}
