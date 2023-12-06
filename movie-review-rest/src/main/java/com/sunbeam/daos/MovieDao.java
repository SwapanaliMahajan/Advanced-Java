package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Movie;

@Repository
public class MovieDao {
@Autowired
  private  JdbcTemplate jdbcTemplate;
@Autowired
private MovieRowMapper movieRowMapper;


public List<Movie> findAll(){
	
	String sql="SELECT * FROM movies";
	List<Movie>list=jdbcTemplate.query(sql,  movieRowMapper);
	return list;
}

public Movie findById(int id) {
	String sql="SELECT * FROM movies WHERE id=?";
	List<Movie> list=jdbcTemplate.query(sql, movieRowMapper,id);
	return list.isEmpty() ? null :list.get(0);
}

public int save(Movie m) {
	String sql="INSERT INTO  movies (id, title, release_date) VALUES(?, ?, ?)";
	int count=jdbcTemplate.update(sql,m.getId(), m.getTitle(), m.getRelease_date());
	return count;
	
}

public  int deleteById(int id) {
	String sql="DELETE FROM movies WHERE id=?";
	int count=jdbcTemplate.update(sql,id);
	
	return count;
}

public int update(Movie m) {
	String sql="update movies set title=?, release_date=? where id=?";
	int count =jdbcTemplate.update(sql,m.getTitle(),m.getRelease_date(), m.getId());
	
	return count;
}

}