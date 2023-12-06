package com.sunbeam.daos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
@Repository
public class ReviewDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReviewRowMapper reviewRowMapper;
	
	public List<Review> findAll(){
	String sql="SELECT * FROM reviews";
	List<Review> list=jdbcTemplate.query(sql,reviewRowMapper);
	return list;
		
		
	}
	
	
	public List<Review>findByuserId(int userId){
	String  sql="SELECT * FROM reviews WHERE user_id=?";
	
	List<Review>list=jdbcTemplate.query(sql,  reviewRowMapper, userId);
	return list;
	}
	
	public Review findById(int reviewId) {
		String sql="SELECT * FROM reviews WHERE id=?";
		List<Review> list=jdbcTemplate.query(sql,reviewRowMapper, reviewId);
	  return list.isEmpty() ? null: list.get(0);	
	
	}
	
	public int save(Review r) {
		String sql="INSERT INTO reviews (id,review, rating, user_id, movie_id, modified) VALUES(?,?,?,?,?,now())";
	int count=jdbcTemplate.update(sql,r.getId(), r.getReview(),r.getRating(),r.getUserId(),r.getMovieId(), r.getModified());
	return count;
	
	
	}
	
	public int deleteById(int reviewId) {
		String sql="DELETE FROM reviews where id=?";
		int count= jdbcTemplate.update(sql, reviewId);
		return count;
	}




	public int update(Review r) {
		 String sql="UPDATE  reviews SET movie_id=?, review=?,rating=?,user_id=?,modified=? WHERE id=?";
		 
		 int count=jdbcTemplate.update(sql, r.getMovieId(),r.getReview(),r.getRating(),r.getUserId(),r.getModified(),r.getId() );
		 
		return count;
	}
	
	
	
}