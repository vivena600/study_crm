package org.ugatu.dto;

import lombok.*;
import org.ugatu.enums.CourseStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortCourseDto {
    private UUID id;
    private String title;
    private String description;
    private CourseStatus status;
    private String photoUrl;
}
