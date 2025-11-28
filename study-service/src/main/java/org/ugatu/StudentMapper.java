package org.ugatu;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ugatu.dto.CreateStudentDto;
import org.ugatu.dto.FullStudentDto;
import org.ugatu.dto.ShortStudentDto;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(FullStudentDto student);

    @Mapping(target = "id", ignore = true)
    Student toCreatedEntity(CreateStudentDto student);

    FullStudentDto toFullStudentDto(Student dto);

    ShortStudentDto toShortStudentDto(Student dto);
}
