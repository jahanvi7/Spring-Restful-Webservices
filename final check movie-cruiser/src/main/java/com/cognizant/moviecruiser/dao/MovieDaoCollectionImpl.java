package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.model.Movie;

@Component
public class MovieDaoCollectionImpl implements MovieDao {

	private Logger LOGGER = LoggerFactory.getLogger(MovieDaoCollectionImpl.class);

	private List<Movie> movieList;

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	public MovieDaoCollectionImpl() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("movie-cruiser.xml");
		movieList = (List<Movie>) context.getBean("movieList");
		;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> customerList = new ArrayList<Movie>();
		for (Movie movie : movieList) {
			if (movie.isActive()
					&& (movie.getDateOfLaunch().equals(new Date()) || movie.getDateOfLaunch().before(new Date()))) {
				customerList.add(movie);
			}
		}
		return customerList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		for (Movie movieInList : movieList) {
			if (movieInList.getId() == movie.getId()) {
				movieInList.setActive(movie.isActive());
				movieInList.setBoxOffice(movie.getBoxOffice());
				movieInList.setDateOfLaunch(movie.getDateOfLaunch());
				movieInList.setGenre(movie.getGenre());
				movieInList.setTeaser(movie.isTeaser());
				movieInList.setTitle(movie.getTitle());
				LOGGER.debug("Modified Movie {} : " + movie);
				break;
			}
		}

	}

	@Override
	public Movie getMovie(long id){
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		for (Movie movie : movieList) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

}
