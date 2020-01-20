package com.mongomvie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongomovie.bo.IMovieService;
import com.mongomvie.vo.TopMovies;

/**
 * @author Ajay Chauhan
 *
 */
@Controller
@RequestMapping("/movie")
public class MovieController
{
	@Autowired
	private IMovieService movieService;
	
	/**
	 * @return json list of top movies
	 */
	@RequestMapping(value="topmovies", method = RequestMethod.GET)
	public @ResponseBody List<TopMovies> getMongoMovies()
	{		
		int sampleCurWeek = 23;
		int sampleCurYear = 2014;
		return movieService.getTopMovies(sampleCurWeek, sampleCurYear);
	}
	
	/**
	 * @param aLanguage
	 * @return success String if movie added successfully
	 */
	@RequestMapping(value="addmovie/{aLanguage}", method = RequestMethod.GET)
	public @ResponseBody String addMovie(@PathVariable String aLanguage)
	{		
		return movieService.addMovie(aLanguage);
 
	}
}
