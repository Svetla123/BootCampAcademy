package com.BootCampAcademy.demo.repository;
import com.BootCampAcademy.demo.Model.User;
import com.BootCampAcademy.demo.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    UserProfile findByUsername(String username);
}
