package org.ugatu;

import org.ugatu.dto.CreateStudentDto;
import org.ugatu.dto.FullStudentDto;
import org.ugatu.dto.ShortStudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    FullStudentDto createdStudent(CreateStudentDto dto);

    List<ShortStudentDto> getAllStudents();

    FullStudentDto getStudentById(UUID id);

    FullStudentDto updateStudyDto(UUID id, CreateStudentDto dto);
}
