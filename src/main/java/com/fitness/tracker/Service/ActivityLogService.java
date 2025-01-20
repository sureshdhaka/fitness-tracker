package com.fitness.tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.tracker.Exception.ResourceNotFoundException;
import com.fitness.tracker.Model.ActivityLog;
import com.fitness.tracker.Repository.ActivityLogRepository;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    public ActivityLog getActivityLogById(Long id) {
        return activityLogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity Log not found"));
    }

    public ActivityLog createActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    public ActivityLog updateActivityLog(Long id, ActivityLog activityLog) {
        if (!activityLogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity Log not found");
        }
        activityLog.setId(id);
        return activityLogRepository.save(activityLog);
    }

    public void deleteActivityLog(Long id) {
        if (!activityLogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity Log not found");
        }
        activityLogRepository.deleteById(id);
    }


}
