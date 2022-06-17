package com.jbfg.lombokproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbfg.lombokproject.model.Member;

@Controller
public class MyController {
	@RequestMapping("/test3")
	public String test3(Member member, Model model) {
		return "test3";
	}
}
