package com.brendan.springdock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brendan.springdock.models.Skill;

/**
 * Repository interface providing CRUD operations for Skill entities.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
