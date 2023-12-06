package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.Review;

@Component
public class ReviewRowMapper implements RowMapper<Review>  {

	
	
	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {

		int id=rs.getInt("id");
		int movieId=rs.getInt("movie_id");
		String review =rs.getString("review");
		int rating=rs.getInt("rating");
		int userId=rs.getInt("user_id");
		Timestamp modified=rs.getTimestamp("modified");
		
		Review   r= new Review (id , movieId, userId, review, rating , modified);
		return r;
	}
	
	
	
	
	
}