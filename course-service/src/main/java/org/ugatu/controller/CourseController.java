package org.ugatu.controller;

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
import org.ugatu.dto.CreateCourseDto;
import org.ugatu.dto.FullCourseDto;
import org.ugatu.dto.ShortCourseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CourseController {

    /**
     * Создание курса
     */
    @PostMapping
    public ResponseEntity<FullCourseDto> createCourse(@Validated @RequestBody FullCourseDto dto) {
        log.info("POST /course with body: {}", dto);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /**
     * Просмотр всех курсов
     */
    @GetMapping
    public ResponseEntity<List<ShortCourseDto>> getCourses() {
        log.info("GET /course");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Просмотр полной информации о курсе по его ID
     */
    @GetMapping("/{courseId}")
    public ResponseEntity<FullCourseDto> getCourseById(@PathVariable UUID courseId) {
        log.info("GET /course/{}",courseId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Обновление информации о курсе
     */
    @PatchMapping("/{courseId}")
    public ResponseEntity<FullCourseDto> updateCourse(@PathVariable UUID courseId, @RequestBody CreateCourseDto dto) {
        log.info("PATCH /course/{}",courseId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
