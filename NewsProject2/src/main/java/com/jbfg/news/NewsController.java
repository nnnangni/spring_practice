//NewsController.java
package com.jbfg.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbfg.news.dao.INewsDAO;
import com.jbfg.news.dto.News;
import com.jbfg.news.service.INewsService;
import com.jbfg.news.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	INewsService dao;
	//INewsDAO dao;  //객체변수 생성
	
//	@GetMapping("/list")
//	public String list(Model m) {
//		List<News> list = dao.list();
//		m.addAttribute("list", list);
//		return "newslist";
//	}
	
	@RequestMapping("/list")
	public String list(Model m) {
		List<News> list = dao.list();
		m.addAttribute("list", list);
		return "newslist";
	}
	
//	@GetMapping("/news/{aid}") // /test/{aid}
//	public String newsView(@PathVariable int aid, Model m) { //@PathVariable : URL 경로에 변수넣어줌
//		News news;
//		news = dao.view(aid);
//		m.addAttribute("news", news);
//		return "newsview";
//	}
	
//	@RequestMapping("/news/{aid}")
//	public String newsView(@RequestParam int aid, Model m) {
//		News dto = dao.view(aid);
//		m.addAttribute("dto", dto);
//		return "newsview";
//	}
	
	@GetMapping("/news/{aid}") // /test/{aid}
	public String newsView(@PathVariable int aid, Model m) { //@PathVariable : URL 경로에 변수넣어줌
		News dto = dao.view(aid);
		m.addAttribute("dto", dto);
		return "newsview";
	}
	
	
//	@PostMapping("/news/add")
//	public String addNews(@ModelAttribute @Valid News news, BindingResult result) {
//		news.setDate("2022-06-08");
//		if(result.getFieldError("title") != null) {
//            System.out.println("1:"+result.getFieldError("title").getDefaultMessage());
//		} else if (result.getFieldError("content")!=null) {
//			System.out.println("2:"+result.getFieldError("content").getDefaultMessage());
//		} else {
//			String sTitle = request.getParameter("title");
//			
//			int count = dao.add(map);
//		}
//		
//		return "redirect:/list";
//	}
	
	@RequestMapping("/news/add")
	public String addNews(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		map.put("title", request.getParameter("title"));
		map.put("content", request.getParameter("content"));
		dao.add(map);
		return "redirect:/list";
	}
	
	@RequestMapping("/delete/{aid}") //호출될 url 지정
	public String delNews(@PathVariable int aid) {
		dao.del(aid);
		return "redirect:/list";
	}
	

	
}
