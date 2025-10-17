package com.brendan.springdock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brendan.springdock.models.User;

/**
 * Repository interface providing CRUD operations for User entities.
 * 
 * It extends the 'JpaRepository' interface from Spring Data JPA, which automatically
 * provides common database operations without the need for boilerplate code.
 * The generic types 'User' and 'Long' specify the entity type and the type of its primary key, respectively.
 * 
 * Spring Data JPA will automatically provide the implementation at runtime.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> { 
    
}
