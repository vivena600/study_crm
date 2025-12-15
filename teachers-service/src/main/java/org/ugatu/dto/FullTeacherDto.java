package org.ugatu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullTeacherDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String email;
    private String photoUrl;
    private String description;
    private Integer experience;
    private List<SkillDto> skills;
    private LocalDateTime createdAt;
}
