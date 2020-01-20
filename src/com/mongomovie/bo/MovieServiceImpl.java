package com.mongomovie.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongomvie.dao.IMovieDAO;
import com.mongomvie.vo.TopMovies;

@Service
public class MovieServiceImpl implements IMovieService
{
	@Autowired
	private IMovieDAO movieDAO;
	
	@Override
	public List<TopMovies> getTopMovies(int aCurWeek, int aCurrYear)
	{
		List <TopMovies> topMovies = movieDAO.getTopMovies(aCurWeek, aCurrYear);
		return topMovies;
	}

	@Override
	public String addMovie(String aLanguage)
	{
		return movieDAO.addMovie(aLanguage);
	}

}
