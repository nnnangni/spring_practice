package com.jbfg.springguestbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbfg.springguestbook.dao.IGuestbookDAO;
import com.jbfg.springguestbook.dto.Guestbook;
import com.jbfg.springguestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService dao;
	
	@RequestMapping("/")
	public ModelAndView root() {
		
		// 1. GuestbookDAO에 대한 인스턴스를 얻어둔다.
		// 2. View로 전달하기 위한 Model를 얻어온다.(Model, ModelAndView)
		ModelAndView mv = new ModelAndView();
		// 3. DAO의 getAll()로 List<Guestbook>을 얻어온다.
		List<Guestbook> guestbook = dao.getAll();
		// 4. model.addattribute로 값을 저장한다.
		mv.addObject("list",guestbook);
		mv.setViewName("guestbook");
		return mv;
	}
	
	@PostMapping("/add")
	public String add(@Valid Guestbook guestbook, BindingResult result) {
		if(result.getFieldErrorCount()>0) {
			
		} else {
			//그냥 insert 하면 regdate 가 빠져있음

			dao.insert(guestbook);
		}
		
		return "redirect:/";
	}
	
	//"modify/"+seq;
	@GetMapping("/modify/{seq}")
	public String modify(@PathVariable int seq, Model model) {
		Guestbook guestbook = dao.getGuestbook(seq);
		model.addAttribute("guestbook", guestbook);
		
		return "guestbook_modify";
	}
	
	@PostMapping("/update")
	public String update(@Valid Guestbook guest, BindingResult result) {
		if(result.getFieldErrorCount()>0) {
			
		} else {
			dao.update(guest);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{seq}")
	public String delete(@PathVariable int seq) {
		dao.delete(seq);
		return "redirect:/";
	}
}
