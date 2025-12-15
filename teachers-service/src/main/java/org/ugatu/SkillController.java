package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ugatu.dto.CreateSkillDto;
import org.ugatu.dto.SkillDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teacher/{id}/skill")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SkillController {
    private final SkillService skillService;

    /**
     * Добавление навыка на профиле преподавателя
     **/
    @PostMapping
    public ResponseEntity<SkillDto> createSkill(@PathVariable("id") UUID id,
                                                @Validated @RequestBody CreateSkillDto dto) {
        log.info("POST /teacher/{}/skill with body {}", id, dto.toString());
        return new ResponseEntity<>(skillService.createSkill(id, dto), HttpStatus.CREATED);
    }

    /**
     * Получение информации о навыках преподавателя
     **/
    @GetMapping
    public ResponseEntity<List<SkillDto>> getSkills(@PathVariable("id") UUID id) {
        log.info("GET /teacher/{}/skill", id);
        return new ResponseEntity<>(skillService.listSkills(id), HttpStatus.OK);
    }
}
