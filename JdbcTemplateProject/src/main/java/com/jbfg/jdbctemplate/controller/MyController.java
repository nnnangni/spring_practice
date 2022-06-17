package com.jbfg.jdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbfg.jdbctemplate.dao.MyUserDao;
import com.jbfg.jdbctemplate.dto.MyUserDto;

@Controller
public class MyController {
	
	@Autowired
	private MyUserDao userDAO;
	
	//@RequestMapping(value="/user", method=RequestMethod.GET)
	@GetMapping("/user")
	public String userlist(Model m) {
		List<MyUserDto> list = userDAO.list();
		
		m.addAttribute("users",list);
		return "userlist";
	}
}
