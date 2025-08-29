package com.shrihari.jobapplication.controller;

import com.shrihari.jobapplication.model.Profile;
import com.shrihari.jobapplication.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("profiles")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("profile/{profileId}")
    public Profile getProfile(@PathVariable("profileId") Long profileId) {
        return profileService.getProfile(profileId);
    }

    @PostMapping(path = "profile", consumes = {"application/json"})
    public Profile addProfile(@RequestBody Profile profile) {
        profileService.addProfile(profile);
        return profileService.getProfile(profile.getId());
    }

    @PutMapping("profile")
    public Profile updateProfile(@RequestBody Profile profile) {
        profileService.updateProfile(profile);
        return profileService.getProfile(profile.getId());
    }

    @DeleteMapping("profile/{profileId}")
    public String deleteProfile(@PathVariable("profileId") Long profileId) {
        profileService.deleteProfile(profileId);
        return "Deleted";
    }
}

