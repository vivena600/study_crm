package org.ugatu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentDto {
    @NotBlank
    @Length(max = 100)
    private String firstName;

    @NotBlank
    @Length(max = 100)
    private String lastName;

    @Length(max = 100)
    private String middleName;

    @Past(message = "Enter valid date of your birth")
    private LocalDateTime dateOfBirth;

    @Length(max = 20)
    private String phoneNumber;

    @NotBlank
    @Length(max = 200)
    private String email;

    private String photoUrl;
}
