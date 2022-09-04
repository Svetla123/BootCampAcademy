package com.BootCampAcademy.demo.repository;

import com.BootCampAcademy.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRespository extends JpaRepository<Comment, Long> {
}
