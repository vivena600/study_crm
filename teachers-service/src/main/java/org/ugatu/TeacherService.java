package org.ugatu;

import org.ugatu.dto.CreateTeacherDto;
import org.ugatu.dto.FullTeacherDto;
import org.ugatu.dto.ShortTeacherDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

    FullTeacherDto createdTeacher(CreateTeacherDto dto);

    List<ShortTeacherDto> getAllTeachers();

    FullTeacherDto getTeacherById(UUID id);

    FullTeacherDto updateTeacher(UUID id, CreateTeacherDto dto);
}
