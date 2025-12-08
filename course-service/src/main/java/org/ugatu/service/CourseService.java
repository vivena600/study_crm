package org.ugatu.service;

import org.ugatu.dto.CreateCourseDto;
import org.ugatu.dto.FullCourseDto;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    FullCourseDto createCourse(CreateCourseDto dto);

    List<FullCourseDto> getCourses();

    FullCourseDto getCourseById(UUID id);

    FullCourseDto updateCourse(UUID id, CreateCourseDto dto);
}
