package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {


}
