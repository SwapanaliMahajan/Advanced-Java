package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.Movie;

@Component
public class MovieRowMapper implements RowMapper<Movie> {
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id=rs.getInt("id");
		String title=rs.getString("title");
		Date rel_date=rs.getDate("release_date");
		Movie m=new Movie(id, title, rel_date);
		return m;

}
}