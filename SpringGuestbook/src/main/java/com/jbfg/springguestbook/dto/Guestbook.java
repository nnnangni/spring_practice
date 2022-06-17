package com.jbfg.springguestbook.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //전체 생성자 만들기
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Data
@Entity(name="guestbook")
public class Guestbook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seq;
	
	@NotNull(message="title is null")
	@NotEmpty(message="title is empty")
	@Size(min=5, message="title min 5")
	private String title;
	
	
	@NotNull(message="content is null")
	@NotEmpty(message="content is empty")
	@Size(min=10, message="content min10")	
	private String content;
	
	private String regdate;
	
	@NotNull(message="username is null")
	@NotEmpty(message="username is empty")
	@Size(min=10, message="username min3")	
	private String username;
	
//	@Builder
//	public Guestbook(String title, String content, String username) {
//		this.title = title;
//		this.content = content;
//		this.username = username;
//		this.regdate = "2022-06-08";
//	}
}
