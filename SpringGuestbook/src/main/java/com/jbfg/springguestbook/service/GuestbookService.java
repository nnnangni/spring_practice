package com.jbfg.springguestbook.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.jbfg.springguestbook.dto.Guestbook;
import com.jbfg.springguestbook.repository.GuestbookRepository;

public class GuestbookService {
	@Autowired
	GuestbookRepository repository;
	
	public List<Guestbook> getAll(){
		List<Guestbook> list = repository.findAll(); //목록을 가져옴
		return list;
	}
	public Guestbook getGuestbook(int seq) {
		Optional<Guestbook> optionalGuestbook = repository.findById(seq);
		return optionalGuestbook.get();
	}
	public int insert(Guestbook guestbook) {
		
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = formatter.format(now);
		guestbook.setRegdate(today);
		
		repository.save(guestbook);
		
		return 1;
	}
	public int update(Guestbook guestbook) {
		
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = formatter.format(now);
		guestbook.setRegdate(today);
		
		repository.save(guestbook);
		return 1;
	}
	public int delete(int seq) {
		repository.deleteById(seq);
		return 1;
	}
	
}
