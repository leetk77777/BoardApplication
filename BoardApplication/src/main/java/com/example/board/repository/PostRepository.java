package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
