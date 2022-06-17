package com.jbfg.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//스프링 빈으로 등록하기 위한 @Component 
@Component
public class NewsDAO {
	
//	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	private final String JDBC_URL = "jdbc:mysql://localhost:3306/jbfg?serverTimezone=UTC"; 
//	private final String USER_ID = "root"; 
//	private final String USER_PASS = "root123456"; 
	
	@Autowired
	DataSource ds;
	
	private Connection open() {
		Connection conn = null;
		try {
			//Data Access Object
			conn = ds.getConnection();
;			//Class.forName(JDBC_DRIVER);
			//conn = DriverManager.getConnection(JDBC_URL,USER_ID,USER_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	}
	
	public int addNews(News news) throws SQLException {
		Connection conn = open(); //db연결
		//2. SQL 만들기
		String insertSql = "insert into news(title,content,date) values(?,?,now())";
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		pstmt.setString(1, news.getTitle());
		pstmt.setString(2, news.getContent());
		//3. 서버에 저장하기
		int count = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return count;
	}
	
	public List<News> getAll() throws SQLException{
		Connection conn = open(); //db연결
		
		String selectSql = "select * from news";
		Statement stmt = conn.createStatement(); // 순방향으로만 데이터를 읽어내려간다
		ResultSet rs = stmt.executeQuery(selectSql);
		
		List<News> newsList = new ArrayList<News>();
		while (rs.next()) {
			int aid = rs.getInt("aid");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String date = rs.getString("date");
			
			News news = new News();
			news.setAid(aid);
			news.setTitle(title);
			news.setContent(content);
			news.setDate(date);
			
			newsList.add(news);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return newsList;
		
	}
	
	public News getNews(int aid) throws SQLException {
		Connection conn = open();
		String selectSql = "select * from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setInt(1,aid);
		ResultSet rs = pstmt.executeQuery();
		
		News news = null;
		if(rs.next()) {
			int aid2 = rs.getInt("aid");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String date = rs.getString("date");	
			news = new News();
			news.setAid(aid2);
			news.setTitle(title);
			news.setContent(content);
			news.setDate(date);
		}
		return news;
	}
	
	public int delNews(int aid) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,aid);
		int count = pstmt.executeUpdate();
		
		return count;
	}

	
}
