package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/admin")
	public List<Movie> getAllMoviesAdmin(){
		return movieService.getMovieListAdmin();
	}
	
	@GetMapping
	public List<Movie> getAllMoviesCustomer(){
		return movieService.getMovieListCustomer();
	}
	
	@PutMapping
	public void modifyMovie(@RequestBody Movie movie) {
		LOGGER.info("START");
		movieService.modifyMovie(movie);
		LOGGER.debug("Modified Movie {} : "+movie);
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) {
		LOGGER.info("Start");
		Movie movie =  movieService.getMovie(id);
		return movie;
	}
	
}
