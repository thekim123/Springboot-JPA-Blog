package com.thekim12.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ORM -> Java(다른 언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성됨.
//@DynamicInsert // insert시에 null인 필드를 제외 시킴.
public class User {
	  
	@Id //Primary key
	@GeneratedValue(strategy =  GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전량을 따라감.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) // 해쉬로 변경해서 비밀번호를 암호화하기 때문.
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;

	//@ColumnDefault("user")
	// DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. domain설정 가능 = 범위 설정 가능
	
	private String oauth; // kakao, google
	
	@CreationTimestamp  // 시간이 자동 입력
	private Timestamp createDate;
	
}
