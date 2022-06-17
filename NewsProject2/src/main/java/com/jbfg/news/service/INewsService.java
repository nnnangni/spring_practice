//INewsService.java
package com.jbfg.news.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jbfg.news.dto.News;

public interface INewsService {
	public List<News> list();
	public News view(int aid);
	public int add(Map<String, String> map);
	public int del(@Param("aid") int aid);
}
