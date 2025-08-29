package com.shrihari.jobapplication.service;

import com.shrihari.jobapplication.model.Application;
import com.shrihari.jobapplication.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    public Application getApplication(Long appId) {
        return applicationRepo.findById(appId).orElse(new Application());
    }

    public void applyJob(Application application) {
        applicationRepo.save(application);
    }

    public void deleteApplication(Long appId) {
        applicationRepo.deleteById(appId);
    }

    public void updateApplication(Application application) {
        applicationRepo.save(application);
    }
}
