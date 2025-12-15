package org.ugatu.service;

import org.ugatu.dto.CreateCourseDto;
import org.ugatu.dto.FullCourseDto;
import org.ugatu.dto.ShortCourseDto;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    FullCourseDto createCourse(CreateCourseDto dto);

    List<ShortCourseDto> getCourses();

    FullCourseDto getCourseById(UUID id);

    FullCourseDto updateCourse(UUID id, CreateCourseDto dto);
}
