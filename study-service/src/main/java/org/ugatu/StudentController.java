package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ugatu.dto.CreateStudentDto;
import org.ugatu.dto.FullStudentDto;
import org.ugatu.dto.ShortStudentDto;

import java.util.List;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
@Slf4j
@Validated
public class StudentController {

    /** Создание студента **/
    @PostMapping
    public ResponseEntity<FullStudentDto> createdStudy(@RequestBody @Validated CreateStudentDto dto) {
        log.info("POST /study with body {}", dto.toString());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /** Получение всех пользователей **/
    @GetMapping
    public ResponseEntity<List<ShortStudentDto>> getAllStudy() {
        log.info("GET /study");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /** Получение информации пользователя по его id **/
    @GetMapping("/{id}")
    public ResponseEntity<List<FullStudentDto>> getStudyById() {
        log.info("GET /study/id");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /** Получение информации пользователя по его id **/
    @PutMapping("/{id}")
    public ResponseEntity<List<FullStudentDto>> updateStudent() {
        log.info("GET /study/id");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
