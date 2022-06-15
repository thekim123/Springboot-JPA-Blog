package com.thekim12.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thekim12.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
