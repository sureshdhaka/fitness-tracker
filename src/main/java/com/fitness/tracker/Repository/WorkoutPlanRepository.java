package com.fitness.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.tracker.Model.User;
import com.fitness.tracker.Model.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    
    WorkoutPlan findByUser(User user);

}
