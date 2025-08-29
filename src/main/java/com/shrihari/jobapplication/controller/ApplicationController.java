package com.shrihari.jobapplication.controller;

import com.shrihari.jobapplication.model.Application;
import com.shrihari.jobapplication.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("applications")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("application/{appId}")
    public Application getApplication(@PathVariable("appId") Long appId) {
        return applicationService.getApplication(appId);
    }

    @PostMapping(path = "application", consumes = {"application/json"})
    public Application applyJob(@RequestBody Application application) {
        applicationService.applyJob(application);
        return applicationService.getApplication((long) application.getApplicationId());
    }

    @PutMapping("application")
    public Application updateApplication(@RequestBody Application application) {
        applicationService.updateApplication(application);
        return applicationService.getApplication((long) application.getApplicationId());
    }

    @DeleteMapping("application/{appId}")
    public String deleteApplication(@PathVariable("appId") Long appId) {
        applicationService.deleteApplication(appId);
        return "Deleted";
    }
}

