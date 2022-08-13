package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}
