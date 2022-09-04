package com.BootCampAcademy.demo.service;

import com.BootCampAcademy.demo.model.Comment;


import java.util.List;

public interface ICommentService {
    Comment findCommentById(Long id);
    List<Comment> findAllComments();
    Comment createComment(Comment comment);
    boolean deleteComment(long id);
    Comment updateComment(long id, Comment comment);

}
