package com.mongomvie.dao;

import java.util.List;

import com.mongomvie.vo.TopMovies;

/**
 * @author Ajay Chauhan
 *
 */
public interface IMovieDAO
{
	/**
	 * @param aCurWeek - current week for which top movies required
	 * @param aCurrYear - current year for which top movies required
	 * @return
	 */
	public List<TopMovies> getTopMovies(int aCurWeek, int aCurrYear);
	
	
	/**
	 * @param aLanguage - Language of the movie
	 * @return String - success or failure
	 */
	public String addMovie(String aLanguage);

}
