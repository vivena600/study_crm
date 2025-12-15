package org.ugatu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ugatu.enums.LessonType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLessonDto {
    @NotBlank(message = "lesson title connote be empty")
    private String title;

    private String textLesson;

    @Builder.Default
    private LessonType lessonType = LessonType.THEORY;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
