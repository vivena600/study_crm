package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ugatu.dto.CreateTeacherDto;
import org.ugatu.dto.FullTeacherDto;
import org.ugatu.dto.SkillDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teacher/{id}/skill")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SkillController {

    /**
     * Добавление навыка на профиле преподавателя
     **/
    @PostMapping
    public ResponseEntity<FullTeacherDto> createSkill(@PathVariable("id") UUID id,
                                                      @Validated @RequestBody CreateTeacherDto dto) {
        log.info("POST /teacher/{}/skill with body {}", id, dto.toString());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /**
     * Получение информации о навыках преподавателя
     **/
    @GetMapping
    public ResponseEntity<List<SkillDto>> getSkills(@PathVariable("id") UUID id) {
        log.info("GET /teacher/{}/skill", id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
