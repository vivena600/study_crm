package org.ugatu;

import org.ugatu.dto.CreateSkillDto;
import org.ugatu.dto.SkillDto;

import java.util.List;
import java.util.UUID;

public interface SkillService {
    SkillDto createSkill(UUID teacherId, CreateSkillDto dto);
    List<SkillDto> listSkills(UUID teacherId);
}
