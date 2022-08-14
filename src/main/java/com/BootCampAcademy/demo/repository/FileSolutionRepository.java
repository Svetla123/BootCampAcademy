package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.FileSolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

public interface FileSolutionRepository extends JpaRepository<FileSolution, Long> {
}
