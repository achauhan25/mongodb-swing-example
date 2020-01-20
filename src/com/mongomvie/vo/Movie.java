package com.mongomvie.vo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ajay Chauhan
 *
 */
@Document(collection = "movies")
public class Movie
{
	@Id
	private String id;
	
	private String movieName;
	
	private String movieDirector;
	
	private String prodnHouse;
	
	private List<String> actors;
	
	private String musicDirector;
	
	private Date releaseDate;
	
	private List<String> langGenreTags;
	
	private LastCollection lastCollctn;
	
	private double totalCollctn;
	
	private int fbMentions;
	
	private int twtMentions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getProdnHouse() {
		return prodnHouse;
	}

	public void setProdnHouse(String prodnHouse) {
		this.prodnHouse = prodnHouse;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getLangGenreTags() {
		return langGenreTags;
	}

	public void setLangGenreTags(List<String> langGenreTags) {
		this.langGenreTags = langGenreTags;
	}

	public LastCollection getLastCollctn() {
		return lastCollctn;
	}

	public void setLastCollctn(LastCollection lastCollctn) {
		this.lastCollctn = lastCollctn;
	}

	public double getTotalCollctn() {
		return totalCollctn;
	}

	public void setTotalCollctn(double d) {
		this.totalCollctn = d;
	}

	public int getFbMentions() {
		return fbMentions;
	}

	public void setFbMentions(int fbMentions) {
		this.fbMentions = fbMentions;
	}

	public int getTwtMentions() {
		return twtMentions;
	}

	public void setTwtMentions(int twtMentions) {
		this.twtMentions = twtMentions;
	}

}
