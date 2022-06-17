//News.java
package com.jbfg.news.dto;

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

@Data //DB 테이블에서 SQL 쿼리로 발생하는 데이터를 처리하기 위한 것 (getter, setter 만들지 않고 롬복 @Data 추가)
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity(name="news") //테이블명
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	
	@NotNull(message="title is null")
	@NotEmpty(message="title is empty")
	@Size(min=5, message="title min 3")
	private String title;
	
	@Builder
	public News(String title, String content) {
		this.title = title;
		this.content = content;
		this.date = "2022-06-08";
	}
	
	private String date;
	
	@NotNull(message="content is null")
	@NotEmpty(message="content is empty")
	@Size(min=10, message="content min3")	
	private String content;
	
}
