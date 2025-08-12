package com.brendanddev.learning_path_api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brendanddev.learning_path_api.model.Skill;

/**
 * Repository interface for Skill entities.
 * Extends JpaRepository to provide CRUD operations and pagination for Skill objects.
 * 
 * This interface allows for easy interaction with the database without needing to implement methods manually.
 * Spring Data JPA will automatically generate the implementation at runtime.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {
    // Additional query methods can be defined here if needed
}
