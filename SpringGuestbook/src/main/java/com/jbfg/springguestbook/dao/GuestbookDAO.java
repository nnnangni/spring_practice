package com.jbfg.springguestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jbfg.springguestbook.dto.Guestbook;

@Repository
public class GuestbookDAO implements IGuestbookDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	class GuestbookMapper implements RowMapper<Guestbook>{
		
		@Override
		public Guestbook mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Guestbook guestbook = new Guestbook();
			//if (rs.next()) {
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				String username = rs.getString("username");
				

				guestbook.setSeq(seq);
				guestbook.setTitle(title);
				guestbook.setContent(content);
				guestbook.setRegdate(regdate);
				guestbook.setUsername(username);				
			//}

			return guestbook;
		
		}
	}
	
	@Override
	public List<Guestbook> getAll() {
		String selectSql = "select * from guestbook";
		List<Guestbook> guestList = template.query(selectSql, new GuestbookMapper());
		return guestList;
	}

	@Override
	public Guestbook getGuestbook(int seq) {
		String selectSql = "select * from guestbook where seq=?";
		Guestbook guestbook = template.queryForObject(selectSql, new BeanPropertyRowMapper<Guestbook>(Guestbook.class), seq);
		return guestbook;
	}

	@Override
	public int insert(Guestbook guestbook) {
		String insertSql = "insert into guestbook(title, content, username, regdate) values(?,?,?,now())";
		//template.update(insertSql,guestbook.getTitle(),guestbook.getContent(), guestbook.getUsername());
		Object[] param = {guestbook.getTitle(), guestbook.getContent(), guestbook.getUsername()};
		template.update(insertSql,param);
		return 0;
	}

	@Override
	public int update(Guestbook guestbook) {
		String updateSql = " update guestbook set username=?, title=?,content=? where seq=?";
		Object[] param = {guestbook.getUsername(), guestbook.getTitle(), guestbook.getContent(), guestbook.getSeq()};
		template.update(updateSql, param);
		return 0;
		
	}

	@Override
	public int delete(int seq) {
		String deleteSql = " delete from guestbook where seq=?";
		template.update(deleteSql, seq);
		return 0;
		
	}
}
