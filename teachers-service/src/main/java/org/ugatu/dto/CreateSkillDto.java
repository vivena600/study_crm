package org.ugatu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSkillDto {

    @NotBlank
    @Length(max = 100)
    private String title;

    @NotBlank
    @Length(max = 512)
    private String description;

    @NotBlank
    @Length(max = 100)
    private String document;
}
