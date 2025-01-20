package com.fitness.tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.tracker.Exception.ResourceNotFoundException;
import com.fitness.tracker.Model.WorkoutPlan;
import com.fitness.tracker.Repository.WorkoutPlanRepository;

@Service
public class WorkoutPlanService {

  @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlan getWorkoutPlanById(Long id) {
        return workoutPlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Workout Plan not found"));
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }

    public WorkoutPlan updateWorkoutPlan(Long id, WorkoutPlan workoutPlan) {
        if (!workoutPlanRepository.existsById(id)) {
            throw new ResourceNotFoundException("Workout Plan not found");
        }
        workoutPlan.setId(id);
        return workoutPlanRepository.save(workoutPlan);
    }

    public void deleteWorkoutPlan(Long id) {
        if (!workoutPlanRepository.existsById(id)) {
            throw new ResourceNotFoundException("Workout Plan not found");
        }
        workoutPlanRepository.deleteById(id);
    }

}
