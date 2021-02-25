package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	private Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	public List<Movie> getMovieListAdmin(){
		return movieDao.getMovieListAdmin();
	}
	
	public List<Movie> getMovieListCustomer(){
		return movieDao.getMovieListCustomer();
	}
	
	public void modifyMovie(Movie movie) {
		LOGGER.info("Start");
		movieDao.modifyMovie(movie);
		LOGGER.debug("Modified Movie {} : "+movie);
	}
	
	public Movie getMovie(long id){
		LOGGER.info("Start");
		return movieDao.getMovie(id);
	}
}
