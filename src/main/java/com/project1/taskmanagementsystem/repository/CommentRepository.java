package com.project1.taskmanagementsystem.repository;

import com.project1.taskmanagementsystem.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
