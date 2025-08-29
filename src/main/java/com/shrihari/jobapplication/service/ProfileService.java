package com.shrihari.jobapplication.service;

import com.shrihari.jobapplication.model.Profile;
import com.shrihari.jobapplication.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public Profile getProfile(Long profileId) {
        return profileRepo.findById(profileId).orElse(null);
    }

    public void addProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void updateProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void deleteProfile(Long profileId) {
        profileRepo.deleteById(profileId);
    }



//    getProfile(Long userId)
//
//updateProfile(ProfileDto dto, Long userId)
//
//uploadResume(MultipartFile file)


}
