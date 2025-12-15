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
    @PostMapping("/admin")
    public ResponseEntity<FullStudentDto> createdStudy(@RequestBody @Validated CreateStudentDto dto) {
        log.info("POST /students/admin with body {}", dto.toString());
        FullStudentDto result = studentService.createdStudent(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Получение всех пользователей
     **/
    @GetMapping("/admin")
    public ResponseEntity<List<ShortStudentDto>> getAllStudy() {
        log.info("GET /students/admin");
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    /**
     * Получение информации пользователя по его id
     **/
    @GetMapping("/{id}")
    public ResponseEntity<FullStudentDto> getStudyById(@PathVariable UUID id) {
        log.info("GET /study/{}", id);

        //TODO - Добавить проверку роли пользователя
        // Студент может смотреть ТОЛЬКО свой профиль
        /*
        if ("STUDENT".equals(userRole) && !currentUserId.equals(id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Менеджер — может смотреть любой
        if ("MANAGER".equals(userRole)) {
            return ResponseEntity.ok(studentService.getStudentById(id));
        }
         */

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