package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.model.CourseTeacher;

import java.util.List;
import java.util.UUID;

public interface CourseTeacherRepository extends JpaRepository<CourseTeacher, UUID> {

    Boolean existsByCourseIdAndTeacherId(UUID courseId, UUID teacherId);

    List<CourseTeacher> findByTeacherId(UUID teacherId);
}
