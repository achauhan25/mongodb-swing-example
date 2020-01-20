package com.mongomvie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Repository;

import com.mongomvie.vo.LastCollection;
import com.mongomvie.vo.Movie;
import com.mongomvie.vo.TopMovies;

/**
 * @author Ajay Chauhan
 *
 */

@Repository
public class MovieDAOImpl implements IMovieDAO
{
	@Autowired
	private MongoOperations mongoMediaOperation;
	
	@Override
	public List<TopMovies> getTopMovies(int aCurWeek, int aCurrYear) 
	{
		List<TopMovies> returnTopList = new ArrayList<TopMovies>();
		
		Map<String, Object> scopeVars = new HashMap<String, Object>();
		scopeVars.put("curWeek", aCurWeek);
		scopeVars.put("curYear", aCurrYear);
		MapReduceOptions mapVarsOp = new MapReduceOptions();
		// return output inline instead of saving in another collection
		mapVarsOp.outputTypeInline();
		mapVarsOp.scopeVariables(scopeVars);
		
		MapReduceResults<TopMovies> results = mongoMediaOperation.mapReduce("movies", "classpath:mapMovies.js", "classpath:reduceMovies.js", mapVarsOp, TopMovies.class);
		for (TopMovies valueObject : results) 
		{
			returnTopList.add(valueObject);
		}
		return returnTopList;
	}

	@Override
	public String addMovie(String aLanguage)
	{
		Movie testMovie = new Movie();
		testMovie.setMovieName("LifeOfPi"+"-"+aLanguage);
		testMovie.setReleaseDate(new Date());
		testMovie.setTotalCollctn(1500*(Math.random()));
		LastCollection lstCollectn = new LastCollection();
		lstCollectn.setWeek(23);
		lstCollectn.setYear(2014);
		lstCollectn.setAmountCollected(100*(Math.random()));
		testMovie.setLastCollctn(lstCollectn);
		List<String> tags = new ArrayList<String>();
		tags.add(aLanguage);
		tags.add("AJ");
		testMovie.setLangGenreTags(tags);
		List<String> actors = new ArrayList<String>();
		actors.add("Suraj");
		actors.add("Irrfan");
		testMovie.setActors(actors);
		
		// save movie to collection
		mongoMediaOperation.insert(testMovie);
		
		return "success";
	}

}
