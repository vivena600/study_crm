package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.model.Course;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
