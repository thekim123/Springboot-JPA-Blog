package com.thekim12.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thekim12.blog.model.User;

// DAO
// 자동으로 bean등록이 된다.
// @Repository 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {
	//select * from user where username = 1?;
	Optional<User> findByUsername(String username);
}









//JPA Naming 쿼리
//select * from user where username = username and password=password
//	User findByUsernameAndPassword(String username, String password) ;


//	@Query(value="select * from user where username= ?1 and password = ?2", nativeQuery = true)
//	User login(String username, String password);