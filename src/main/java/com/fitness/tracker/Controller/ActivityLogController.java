package com.fitness.tracker.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitness.tracker.Model.ActivityLog;
import com.fitness.tracker.Service.ActivityLogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {


    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping("/{id}")
    public ResponseEntity<ActivityLog> getActivityLog(@PathVariable Long id) {
        return ResponseEntity.ok(activityLogService.getActivityLogById(id));
    }

    @PostMapping
    public ResponseEntity<ActivityLog> createActivityLog(@Valid @RequestBody ActivityLog activityLog) {
        return new ResponseEntity<>(activityLogService.createActivityLog(activityLog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityLog> updateActivityLog(@PathVariable Long id, @Valid @RequestBody ActivityLog activityLog) {
        return ResponseEntity.ok(activityLogService.updateActivityLog(id, activityLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityLog(@PathVariable Long id) {
        activityLogService.deleteActivityLog(id);
        return ResponseEntity.noContent().build();
    }
}
