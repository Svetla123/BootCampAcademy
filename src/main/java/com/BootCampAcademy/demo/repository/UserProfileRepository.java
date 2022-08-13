package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {


}
