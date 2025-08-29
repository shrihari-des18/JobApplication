package com.shrihari.jobapplication.service;

import com.shrihari.jobapplication.model.User;
import com.shrihari.jobapplication.repo.JobRepo;
import com.shrihari.jobapplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JobRepo jobRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void blockUser(int userId) {

    }

    public void unblockUser(int userId) {
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteById(jobId);
    }
}
