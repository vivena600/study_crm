package org.ugatu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ugatu.dto.ShortCourseDto;
import org.ugatu.service.StudentService;
import org.ugatu.service.TeacherService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course/student/{studentId}")
@RequiredArgsConstructor
@Slf4j
public class CourseStudentController {
    private final StudentService studentService;

    /**
     * Назначение студента на курс
     */
    @PostMapping("/{courseId}")
    public ResponseEntity<Void> assignStudent(
            @PathVariable(name = "courseId") UUID courseId,
            @PathVariable(name = "studentId") UUID studentId) {
        log.info("Assign student {} to course {}", studentId, courseId);
        studentService.assignStudent(courseId, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ShortCourseDto>> getCoursesByStudent(@PathVariable UUID studentId) {
        log.info("Get courses by student {}", studentId);
        return ResponseEntity.ok(studentService.getCoursesByStudent(studentId));
    }
}
