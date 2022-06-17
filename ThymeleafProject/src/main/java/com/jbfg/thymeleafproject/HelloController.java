package com.jbfg.thymeleafproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model m) {
		m.addAttribute("data", "hello!");
		return "hello";
	}
	
	@RequestMapping("/")
	public String indexPage(Model m) {
		Board board = new Board(1,"타임리프 예제","Honggd");
		m.addAttribute("board",board);	
		return "index";
	}
}
