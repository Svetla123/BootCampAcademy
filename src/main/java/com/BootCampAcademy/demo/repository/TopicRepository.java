package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);

}
