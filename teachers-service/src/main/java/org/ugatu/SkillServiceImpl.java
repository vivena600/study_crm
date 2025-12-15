package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugatu.dto.CreateSkillDto;
import org.ugatu.dto.SkillDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.repository.SkillRepository;
import org.ugatu.repository.TeacherRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final TeacherRepository teacherRepository;


    @Override
    public SkillDto createSkill(UUID teacherId, CreateSkillDto dto) {
        log.info("Create skill by {}", teacherId);
        findTeacherById(teacherId);
        Skill skill = skillMapper.toCreatedEntity(dto);
        skill.setTeacherId(teacherId);
        return skillMapper.toSkillDto(skillRepository.save(skill));
    }

    @Override
    public List<SkillDto> listSkills(UUID teacherId) {
        log.info("List skills by {}", teacherId);
        findTeacherById(teacherId);
        return skillRepository.getSkillsByTeacherId(teacherId).stream()
                .map(skillMapper::toSkillDto)
                .collect(Collectors.toList());
    }

    private void findTeacherById(UUID id) {
        teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher with id " + id + " does not exist"));
    }
}
