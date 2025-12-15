package org.ugatu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTeacherDto {
    @NotBlank
    @Length(max = 100)
    private String firstName;

    @NotBlank
    @Length(max = 100)
    private String lastName;

    @Length(max = 100)
    private String middleName;

    @Past(message = "Дата рождения должна быть в прошлом")
    private LocalDateTime dateOfBirth;

    @Length(max = 20)
    private String phoneNumber;

    @Length(max = 200)
    @Email(message = "Введите корректную почту")
    private String email;

    @URL
    private String photoUrl;

    @Length(max = 512)
    private String description;

    private Integer experience;
}
