package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {
    EducationLevel findByName(String name);
}
