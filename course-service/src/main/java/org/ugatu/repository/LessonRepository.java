package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.model.Course;
import org.ugatu.model.Lesson;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {

    List<Lesson> findByCourseIdOrderByStartTime(UUID courseId);
}
