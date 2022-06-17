package com.jbfg.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jbfg.news.dto.News;

//등록안하기 위해 지움
//@Repository // 현재 클래스에서 db 처리 목적으로 하는 빈 등록 어노테이션
public class NewsDAO implements INewsDAO {
	
	class NewsMapper implements RowMapper<News>{
		
		@Override
		public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			int aid = rs.getInt("aid");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String date = rs.getString("date");
			
			News news = new News(aid, title,content,date);
			news.setAid(aid);
			news.setTitle(title);
			news.setContent(content);
			news.setDate(date);
			
			return news;
		}
	}
	
	@Autowired //JdbcTemplate 변수 자동 주입
	private JdbcTemplate template;
	
	@Override
	public List<News> getAll() {
		
		String selectSql = "select * from news";
		//List<News> list = template.query(selectSql, new NewsMapper());
		List<News> list = template.query(selectSql, new BeanPropertyRowMapper<News>(News.class));
		//selectSql 쿼리 실행, 쿼리 결과를 로우마다 DTO 객체로 받아 전체를 리스트 데이터로 만들기
		//Bean Property를 기반으로 RowMapper를 생성
		
		return list;
		
	}

	@Override
	public int addNews(Map<String, String> map) {
		String insertSql = "insert into news(title, content, date) values(?,?,now())";
		//template.update(insertSql, news.getTitle(), news.getContent());
		template.update(insertSql, new Object[] {news.getTitle(), news.getContent()});
		// title과 content에서 가져온 값을 업데이트
		return 0;
	}



	@Override
	public News getNews(int aid) {
		String selectSql = "select * from news where aid=?";
		News news = template.queryForObject(selectSql, new NewsMapper(), aid);
		return news;
	}

	@Override
	public int delNews(int aid) {
		String deleteSql = "delete from news where aid=?";
		int result = template.update(deleteSql,aid);
		return result;
	}
}
