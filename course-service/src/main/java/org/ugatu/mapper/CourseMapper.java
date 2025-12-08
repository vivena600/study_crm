package org.ugatu.mapper;

import org.springframework.stereotype.Component;
import org.ugatu.dto.CreateCourseDto;
import org.ugatu.dto.FullCourseDto;
import org.ugatu.model.Course;

@Component
public class CourseMapper {

    public Course toEntity(FullCourseDto dto) {
        return Course.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .photoUrl(dto.getPhotoUrl())
                .maxStudents(dto.getMaxStudents())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public Course toNewEntity(CreateCourseDto dto) {
        return Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .photoUrl(dto.getPhotoUrl())
                .maxStudents(dto.getMaxStudents())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();
    }

    public FullCourseDto toDto(Course dto) {
        return FullCourseDto.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .photoUrl(dto.getPhotoUrl())
                .maxStudents(dto.getMaxStudents())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
