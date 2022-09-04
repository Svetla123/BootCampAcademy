package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
}
