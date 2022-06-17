package com.jbfg.springguestbook.dao;

import java.util.List;

import com.jbfg.springguestbook.dto.Guestbook;

public interface IGuestbookDAO {
	
	public List<Guestbook> getAll();
	public Guestbook getGuestbook(int seq);
	public int insert(Guestbook guestbook);
	public int update(Guestbook guestbook);
	public int delete(int seq);
}
