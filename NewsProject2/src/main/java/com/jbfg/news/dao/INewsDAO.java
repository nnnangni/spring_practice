//INewsDAO.java
package com.jbfg.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jbfg.news.dto.News;


@Mapper
public interface INewsDAO {
	public List<News> getAll();
	public int addNews(Map<String, String> map);
	public News getNews(@Param("aid") int aid);
	public int delNews(@Param("aid") int aid);

}
