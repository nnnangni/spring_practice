package com.jbfg.news.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbfg.news.dao.News;
import com.jbfg.news.dao.NewsDAO;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	//NewsDAO dao = new NewsDAO()
	@Autowired
	NewsDAO dao; //선언만 하면 됨
	
	@GetMapping("/list")
	public String list(Model m) throws SQLException {
		List<News> list = dao.getAll();
		m.addAttribute("list",list);
		return "newslist";
	}
	
	//@RequestMapping("/add")
	@PostMapping("/add")
	public String addNews(@ModelAttribute News news) {
		try {
			int count = dao.addNews(news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/news/list"; //response.sendRedirect("/news/list");
	}
	
	@GetMapping("/delete/{aid}") //news?action=delete&aid=3 -> news/delete/3
	public String delNews (@PathVariable int aid, Model m) {
		try {
			int count = dao.delNews(aid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/new/list";
	}
	
	@GetMapping("/{aid}")
	public String newsView(@PathVariable int aid, Model m) {
		News news;
		try {
			news = dao.getNews(aid);
			m.addAttribute("news", news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "newsView";
	}
}
