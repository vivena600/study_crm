package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ugatu.dto.CreateTeacherDto;
import org.ugatu.dto.FullTeacherDto;
import org.ugatu.dto.ShortTeacherDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Slf4j
@Validated
public class TeacherController {

    /**
     * Создание страницы преподавателя
     **/
    @PostMapping
    public ResponseEntity<FullTeacherDto> create(@Validated @RequestBody CreateTeacherDto dto) {
        log.info("POST /teachers with body {}", dto.toString());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /**
     * Получение короткой информации о всех преподавателях
     */
    @GetMapping
    public ResponseEntity<List<ShortTeacherDto>> findAll() {
        log.info("GET /teachers");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Получение полной информации о конкретном пользователе по его id
     */
    @GetMapping("/{id}")
    public ResponseEntity<FullTeacherDto> findById(@PathVariable("id") UUID id) {
        log.info("GET /teachers/{}", id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FullTeacherDto> updateTeacher(@PathVariable("id") UUID id,
                                                        @RequestBody CreateTeacherDto dto) {
        log.info("PUT /teachers/{}", id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
