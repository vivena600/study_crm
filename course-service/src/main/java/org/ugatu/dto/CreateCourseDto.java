package org.ugatu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.ugatu.enums.CourseStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCourseDto {
    @NotBlank
    @Length(max = 100)
    private String title;

    @NotBlank
    private String description;

    @Builder.Default
    private CourseStatus status = CourseStatus.ACTIVE;

    private String photoUrl;

    private Integer maxStudents;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
