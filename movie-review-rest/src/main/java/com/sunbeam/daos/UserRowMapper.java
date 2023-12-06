package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.User;

@Component
public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String fname = rs.getString("first_name");
		String lname = rs.getString("last_name");
		String password = rs.getString("password");
		String email = rs.getString("email");
		String mobile = rs.getString("mobile");
		Date birth = rs.getDate("birth");
		return new User(id, fname, lname, email, password, mobile, birth);
	}
	
	
	
	
}