package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.Model.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {
    EducationLevel findByName(String name);
}
