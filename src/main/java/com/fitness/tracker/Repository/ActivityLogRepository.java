package com.fitness.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.tracker.Model.*;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    
    ActivityLog findByUser(User user);

}
