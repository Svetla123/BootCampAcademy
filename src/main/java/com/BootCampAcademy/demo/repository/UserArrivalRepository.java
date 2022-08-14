package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.UserArrival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserArrivalRepository extends JpaRepository<UserArrival, Long> {
}
