package org.ugatu;

import org.mapstruct.Mapper;
import org.ugatu.dto.CreateStudentDto;
import org.ugatu.dto.FullStudentDto;
import org.ugatu.dto.ShortStudentDto;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(FullStudentDto student);

    Student toCreatedEntity(CreateStudentDto student);

    FullStudentDto toFullStudentDto(Student dto);

    ShortStudentDto toShortStudentDto(Student dto);
}
