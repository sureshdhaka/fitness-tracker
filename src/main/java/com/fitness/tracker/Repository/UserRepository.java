package com.fitness.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.tracker.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);

}
