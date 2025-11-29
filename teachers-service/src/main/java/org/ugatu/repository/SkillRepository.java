package org.ugatu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugatu.Skill;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
}
