package com.shrihari.jobapplication.controller;

import com.shrihari.jobapplication.model.User;
import com.shrihari.jobapplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PutMapping("admin/blockUser/{Id}")
    public String blockUser(@PathVariable("Id") int Id) {
        adminService.blockUser(Id);
        return "User Blocked";
    }

    @PutMapping("admin/unblockUser/{userId}")
    public String unblockUser(@PathVariable("userId") int userId) {
        adminService.unblockUser(userId);
        return "User Unblocked";
    }

    @DeleteMapping("admin/job/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId) {
        adminService.deleteJob(jobId);
        return "Job Deleted by Admin";
    }
}

