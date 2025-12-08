package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.model.CourseStudent;

import java.util.List;
import java.util.UUID;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, UUID> {

    Boolean existsByCourseIdAndStudentId(UUID courseId, UUID studentId);

    List<CourseStudent> findByStudentId(UUID studentId);
}
