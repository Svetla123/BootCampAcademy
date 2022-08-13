package com.BootCampAcademy.demo.controller;

import com.BootCampAcademy.demo.Model.EducationLevel;
import com.BootCampAcademy.demo.Model.UserProfile;
import com.BootCampAcademy.demo.service.IUserProfileService;
import com.BootCampAcademy.demo.service.impl.EducationLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProfileController {

    private IUserProfileService userProfileService;
    private EducationLevelService educationLevelService;

    public UserProfileController(IUserProfileService userProfileService, EducationLevelService educationLevelService) {
        super();
        this.userProfileService = userProfileService;
        this.educationLevelService = educationLevelService;
    }

    @GetMapping("/userProfiles")
    public List<UserProfile> findAll() {
        List<UserProfile> userProfiles = this.userProfileService.findAllUserProfiles();;
        return userProfiles;
    }

    @GetMapping("/userProfiles/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UserProfile userProfile = this.userProfileService.findUserProfileById(id);
        if (userProfile == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserProfile with id " + id + " not found");
        }
        return ResponseEntity.ok(userProfile);
    }

    @DeleteMapping("userProfiles/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.userProfileService.deleteUserProfile(id);

        if (result) {
            return ResponseEntity.ok("UserProfile with id" + id + "deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserProfile with id " + id + " not found");
        }
    }

//expected name of education level
    @PostMapping ("/userProfiles")
    public ResponseEntity<?> create (@RequestBody UserProfile userProfile) {
        userProfile.getEducationLevel().setId(educationLevelService.findEducationLevelByName(userProfile.getEducationLevel().getName()));
//        EducationLevel educationLevel = userProfile.getEducationLevel();
//        Long educationLevelId = educationLevelService.findEducationLevelByName(educationLevel.getName());
//        educationLevel.setId(educationLevelId);
//        userProfile.setEducationLevel(educationLevel);
        UserProfile newUserProfile = this.userProfileService.createUserProfile(userProfile);
        return ResponseEntity.ok(newUserProfile);
    }

    @PutMapping("/userProfiles/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody UserProfile userProfile) {
        if (userProfile.getEducationLevel() != null){
            EducationLevel educationLevel = userProfile.getEducationLevel();
            Long educationLevelId = educationLevelService.findEducationLevelByName(educationLevel.getName());
            educationLevel.setId(educationLevelId);
            userProfile.setEducationLevel(educationLevel);
        }
        UserProfile updatedUserProfile = this.userProfileService.updateUserProfile(id, userProfile);
        if (updatedUserProfile == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserProfile with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUserProfile);
    }
}

