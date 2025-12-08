package org.ugatu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugatu.dto.ShortCourseDto;
import org.ugatu.service.TeacherService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course/teacher/{teacherId}")
@RequiredArgsConstructor
@Slf4j
public class CourseTeacherController {
    private final TeacherService teacherService;

    /**
     * Назначение приподавателя на курс
     */
    @PostMapping("/{courseId}")
    public ResponseEntity<Void> assignTeacher(
            @PathVariable UUID courseId,
            @PathVariable UUID teacherId) {
        log.info("Assign teacher {} to course {}", teacherId, courseId);
        teacherService.assignTeacher(courseId, teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ShortCourseDto>> getCoursesByTeacher(@PathVariable UUID teacherId) {
        log.info("Get courses by teacher {}", teacherId);
        return ResponseEntity.ok(teacherService.getCoursesByTeacher(teacherId));
    }
}
