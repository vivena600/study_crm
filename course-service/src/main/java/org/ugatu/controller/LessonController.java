package org.ugatu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugatu.dto.*;
import org.ugatu.service.CourseService;
import org.ugatu.service.LessonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course/{courseId}")
@RequiredArgsConstructor
@Slf4j
@Validated
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/teacher/{teacherId}/lesson")
    public ResponseEntity<FullLessonDto> createLesson(
            @PathVariable UUID courseId,
            @PathVariable UUID teacherId,
            @Valid @RequestBody CreateLessonDto dto) {

        log.info("POST /course/{}/lesson with body: {}", courseId, dto);
        FullLessonDto lesson = lessonService.createLesson(courseId, dto, teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(lesson);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<FullLessonDto>> getSchedule(@PathVariable UUID courseId) {
        log.info("GET /course/{}/schedule", courseId);
        List<FullLessonDto> schedule = lessonService.getSchedule(courseId);
        return ResponseEntity.ok(schedule);
    }
}
