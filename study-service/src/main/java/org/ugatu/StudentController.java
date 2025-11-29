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
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
@Validated
public class StudentController {
    private final StudentService studentService;

    /**
     * Создание студента
     **/
    @PostMapping
    public ResponseEntity<FullStudentDto> createdStudy(@RequestBody @Validated CreateStudentDto dto) {
        log.info("POST /study with body {}", dto.toString());
        FullStudentDto result = studentService.createdStudent(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Получение всех пользователей
     **/
    @GetMapping
    public ResponseEntity<List<ShortStudentDto>> getAllStudy() {
        log.info("GET /study");
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    /**
     * Получение информации пользователя по его id
     **/
    @GetMapping("/{id}")
    public ResponseEntity<FullStudentDto> getStudyById(@PathVariable UUID id) {
        log.info("GET /study/{}", id);
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    /**
     * Обновление информации о пользователе
     **/
    @PutMapping("/{id}")
    public ResponseEntity<FullStudentDto> updateStudent(@PathVariable UUID id,
                                                        @RequestBody @Validated CreateStudentDto dto) {
        log.info("Put /study/{} with body {}", id, dto.toString());
        return new ResponseEntity<>(studentService.updateStudyDto(id, dto), HttpStatus.OK);
    }
}