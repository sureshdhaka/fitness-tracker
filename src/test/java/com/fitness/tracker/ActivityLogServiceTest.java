

package com.fitness.tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.fitness.tracker.Exception.ResourceNotFoundException;
import com.fitness.tracker.Model.ActivityLog;
import com.fitness.tracker.Repository.ActivityLogRepository;
import com.fitness.tracker.Service.ActivityLogService;



@SpringBootTest(classes = com.fitness.tracker.TrackerApplication.class)
public class ActivityLogServiceTest {

    @InjectMocks
    private ActivityLogService activityLogService;

    @Mock
    private ActivityLogRepository activityLogRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetActivityLogById() {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setId(1L);
        when(activityLogRepository.findById(1L)).thenReturn(Optional.of(activityLog));

        ActivityLog result = activityLogService.getActivityLogById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetActivityLogById_NotFound() {
        when(activityLogRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            activityLogService.getActivityLogById(1L);
        });
    }

    @Test
    public void testCreateActivityLog() {
        ActivityLog activityLog = new ActivityLog();
        when(activityLogRepository.save(any(ActivityLog.class))).thenReturn(activityLog);

        ActivityLog result = activityLogService.createActivityLog(activityLog);

        assertNotNull(result);
    }

    @Test
    public void testUpdateActivityLog() {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setId(1L);
        when(activityLogRepository.existsById(1L)).thenReturn(true);
        when(activityLogRepository.save(any(ActivityLog.class))).thenReturn(activityLog);

        ActivityLog result = activityLogService.updateActivityLog(1L, activityLog);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testUpdateActivityLog_NotFound() {
        ActivityLog activityLog = new ActivityLog();
        when(activityLogRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            activityLogService.updateActivityLog(1L, activityLog);
        });
    }

    @Test
    public void testDeleteActivityLog() {
        when(activityLogRepository.existsById(1L)).thenReturn(true);

        activityLogService.deleteActivityLog(1L);

        verify(activityLogRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteActivityLog_NotFound() {
        when(activityLogRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            activityLogService.deleteActivityLog(1L);
        });
    }
}
