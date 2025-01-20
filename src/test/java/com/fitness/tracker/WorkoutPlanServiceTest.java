
package com.fitness.tracker;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.fitness.tracker.Exception.ResourceNotFoundException;
import com.fitness.tracker.Model.WorkoutPlan;
import com.fitness.tracker.Repository.WorkoutPlanRepository;
import com.fitness.tracker.Service.WorkoutPlanService;




@SpringBootTest
public class WorkoutPlanServiceTest {

    @Mock
    private WorkoutPlanRepository workoutPlanRepository;

    @InjectMocks
    private WorkoutPlanService workoutPlanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWorkoutPlanById() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId(1L);
        when(workoutPlanRepository.findById(1L)).thenReturn(Optional.of(workoutPlan));

        WorkoutPlan result = workoutPlanService.getWorkoutPlanById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetWorkoutPlanById_NotFound() {
        when(workoutPlanRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            workoutPlanService.getWorkoutPlanById(1L);
        });
    }

    @Test
    public void testCreateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        when(workoutPlanRepository.save(workoutPlan)).thenReturn(workoutPlan);

        WorkoutPlan result = workoutPlanService.createWorkoutPlan(workoutPlan);
        assertEquals(workoutPlan, result);
    }

    @Test
    public void testUpdateWorkoutPlan() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId(1L);
        when(workoutPlanRepository.existsById(1L)).thenReturn(true);
        when(workoutPlanRepository.save(workoutPlan)).thenReturn(workoutPlan);

        WorkoutPlan result = workoutPlanService.updateWorkoutPlan(1L, workoutPlan);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testUpdateWorkoutPlan_NotFound() {
        WorkoutPlan workoutPlan = new WorkoutPlan();
        when(workoutPlanRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            workoutPlanService.updateWorkoutPlan(1L, workoutPlan);
        });
    }

    @Test
    public void testDeleteWorkoutPlan() {
        when(workoutPlanRepository.existsById(1L)).thenReturn(true);
        doNothing().when(workoutPlanRepository).deleteById(1L);

        workoutPlanService.deleteWorkoutPlan(1L);
        verify(workoutPlanRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteWorkoutPlan_NotFound() {
        when(workoutPlanRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            workoutPlanService.deleteWorkoutPlan(1L);
        });
    }
}

