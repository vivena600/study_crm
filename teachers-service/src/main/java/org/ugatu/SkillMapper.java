package org.ugatu;

import org.mapstruct.Mapper;
import org.ugatu.dto.CreateSkillDto;
import org.ugatu.dto.SkillDto;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(SkillDto dto);

    Skill toCreatedEntity(CreateSkillDto dto);

    SkillDto toSkillDto(Skill skill);
}
