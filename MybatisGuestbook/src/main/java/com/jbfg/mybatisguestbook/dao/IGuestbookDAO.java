package com.jbfg.mybatisguestbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jbfg.mybatisguestbook.dto.Guestbook;



@Mapper
public interface IGuestbookDAO {
	
	public List<Guestbook> getAll();
	public Guestbook getGuestbook(int seq);
	public int insert(Guestbook guestbook);
	public int update(Guestbook guestbook);
	public int delete(int seq);
}
