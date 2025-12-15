package org.ugatu;

import org.springframework.stereotype.Component;
import org.ugatu.dto.CreateTeacherDto;
import org.ugatu.dto.FullTeacherDto;
import org.ugatu.dto.ShortTeacherDto;
import org.ugatu.dto.SkillDto;

import java.util.List;

@Component
public class TeacherMapper {

    public Teacher toEntity(FullTeacherDto teacher) {
        return Teacher.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .dateOfBirth(teacher.getDateOfBirth())
                .phoneNumber(teacher.getPhoneNumber())
                .email(teacher.getEmail())
                .description(teacher.getDescription())
                .experience(teacher.getExperience())
                .createdAt(teacher.getCreatedAt())
                .photoUrl(teacher.getPhotoUrl())
                .build();
    }

    public FullTeacherDto toFullTeacherDto (Teacher teacher,
                                            List<SkillDto> skills) {
        return FullTeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .dateOfBirth(teacher.getDateOfBirth())
                .phoneNumber(teacher.getPhoneNumber())
                .email(teacher.getEmail())
                .description(teacher.getDescription())
                .experience(teacher.getExperience())
                .createdAt(teacher.getCreatedAt())
                .experience(teacher.getExperience())
                .photoUrl(teacher.getPhotoUrl())
                .skills(skills)
                .build();
    }

    public ShortTeacherDto toShortTeacherDto (Teacher teacher) {
        return ShortTeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .photoUrl(teacher.getPhotoUrl())
                .build();
    }

    public Teacher toEntity(CreateTeacherDto teacher) {
        return Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .dateOfBirth(teacher.getDateOfBirth())
                .phoneNumber(teacher.getPhoneNumber())
                .email(teacher.getEmail())
                .description(teacher.getDescription())
                .experience(teacher.getExperience())
                .experience(teacher.getExperience())
                .photoUrl(teacher.getPhotoUrl())
                .build();
    }
}
