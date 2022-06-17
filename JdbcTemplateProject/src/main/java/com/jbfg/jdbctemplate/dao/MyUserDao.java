package com.jbfg.jdbctemplate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jbfg.jdbctemplate.dto.MyUserDto;

@Repository
public class MyUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource ds;
	
	public List<MyUserDto> list() {
		String sql = "select * from myuser";
		List<MyUserDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MyUserDto>(MyUserDto.class)); // 어떤 타입으로 결과를 저장하는지에 대한 정의
		return list;
	}
}
