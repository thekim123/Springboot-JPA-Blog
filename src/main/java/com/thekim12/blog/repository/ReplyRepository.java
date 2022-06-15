package com.thekim12.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.thekim12.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
	@Modifying
	@Query(value = "insert into reply(userId, boardId, content, createDate) values(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content);
}
