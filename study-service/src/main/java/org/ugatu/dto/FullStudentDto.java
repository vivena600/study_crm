package org.ugatu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullStudentDto {
    private UUID StudyId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String email;
    private String photoUrl;
    private LocalDateTime createdAt;
}
