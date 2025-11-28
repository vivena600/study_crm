package org.ugatu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortStudentDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String photoUrl;
}
