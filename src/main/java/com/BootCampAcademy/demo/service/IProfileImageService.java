package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.model.ProfileImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProfileImageService {
    boolean deleteProfileImage(Long id);

    ProfileImage saveProfileImage(MultipartFile file);

    ProfileImage findProfileImageById(Long id);
    List<ProfileImage> findAllProfileImages();
}
