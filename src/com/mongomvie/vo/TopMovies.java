package com.mongomvie.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Ajay Chauhan
 *
 */
public class TopMovies
{
	@Id
	private String id;
	
	@Field("value")
	private TopMoviesContainer value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TopMoviesContainer getValue() {
		return value;
	}

	public void setValue(TopMoviesContainer value) {
		this.value = value;
	}
}

class TopMoviesContainer
{
	@Field("topData")
	private ArrayList<TopMovieVO> topMovies;

	public ArrayList<TopMovieVO> getTopMovies() {
		return topMovies;
	}

	public void setTopMovies(ArrayList<TopMovieVO> valarr) {
		this.topMovies = valarr;
	}	
}

class TopMovieVO
{
	@Field("movieId")
	private String movieId;
	
	@Field("movieName")
	private String movieName;
	
	@Field("score")
	private double score;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}	
}
