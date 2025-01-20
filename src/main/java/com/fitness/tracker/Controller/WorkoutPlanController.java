package com.fitness.tracker.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitness.tracker.Model.WorkoutPlan;
import com.fitness.tracker.Service.WorkoutPlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workout-plans")
public class WorkoutPlanController {
    
    @Autowired
    private WorkoutPlanService workoutPlanService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getWorkoutPlan(@PathVariable Long id) {
        return ResponseEntity.ok(workoutPlanService.getWorkoutPlanById(id));
    }

    @PostMapping
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@Valid @RequestBody WorkoutPlan workoutPlan) {
        return new ResponseEntity<>(workoutPlanService.createWorkoutPlan(workoutPlan), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutPlan> updateWorkoutPlan(@PathVariable Long id, @Valid @RequestBody WorkoutPlan workoutPlan) {
        return ResponseEntity.ok(workoutPlanService.updateWorkoutPlan(id, workoutPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return ResponseEntity.noContent().build();
    }

}
