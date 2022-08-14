package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.model.UserProfile;

import java.util.List;

public interface IUserProfileService {
    UserProfile findUserProfileById(Long id);
    List<UserProfile> findAllUserProfiles();
    boolean deleteUserProfile (long id);
    UserProfile createUserProfile (UserProfile userProfile);
    UserProfile updateUserProfile (long id, UserProfile userProfile);
}
