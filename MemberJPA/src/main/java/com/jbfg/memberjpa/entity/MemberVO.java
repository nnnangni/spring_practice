package com.jbfg.memberjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //자동으로 값을 만들어줌
	private Long mbrNo;
	
	
	private String id;
	private String name;
	
	@Builder //클래스 만들때	
	public MemberVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getMbrNO() {
		// TODO Auto-generated method stub
		return null;
	}
}
