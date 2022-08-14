package com.BootCampAcademy.demo.repository;
import com.BootCampAcademy.demo.model.User;
import com.BootCampAcademy.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    UserProfile findByUsername(String username);
}
