package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.Model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    Meeting findByName(String name);
}
