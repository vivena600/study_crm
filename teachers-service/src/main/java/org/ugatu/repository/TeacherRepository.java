package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.Teacher;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    boolean existsTeacherByEmail(String email);
}
