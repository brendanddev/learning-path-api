package com.brendanddev.learning_path_api.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Represents a skill or topic that users can learn.
 */
@Entity
public class Skill {

    /**
     * The name of the skill, which serves as the primary key.
     */
    @Id
    private String name;

    /**
     * Users who have this skill.
     * This is the inverse side of the many-to-many relationship with the User entity.
     * Each skill can be associated with multiple users, and users can have multiple skills.
     * The 'mappedBy = skills' attribute indicates that the ownership of the relationship is
     * managed by the 'skills' field in the User entity.
     */
    @ManyToMany(mappedBy = "skills")
    private Set<User> users;

    /**
     * Default constructor required by JPA
     */
    public Skill() {}

    /**
     * Overloaded constructor to create a Skill with a name.
     * 
     * @param name The name of the skill
     */
    public Skill(String name) {
        this.name = name;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
