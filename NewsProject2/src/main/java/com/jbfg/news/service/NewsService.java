//NewsService.java
package com.jbfg.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbfg.news.dao.INewsDAO;
import com.jbfg.news.dto.News;

@Service
public class NewsService implements INewsService {

	@Autowired
	INewsDAO dao;
	//NewsRepository repository;
	
	@Override
	public List<News> list(){
		//List<News> newsList = repository.findAll();
		//return newsList;
		List<News> list = dao.getAll();
		return list;
	};
	
	@Override
	public News view(int aid) {
		return dao.getNews(aid);
	}

	@Override
	public int add(Map<String, String> map) {
		return dao.addNews(map);
	}

	@Override
	public int del(int aid) {
		return dao.delNews(aid);
	};
	
}
