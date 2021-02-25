package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

@Component
public class FavoriteDaoCollectionImpl implements FavoriteDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteDaoCollectionImpl.class);

	private LinkedHashMap<String, Favorite> userFavorites;
	
	public LinkedHashMap<String, Favorite> getUserFavourites() {
		return userFavorites;
	}

	public void setUserFavourites(LinkedHashMap<String, Favorite> userFavourites) {
		this.userFavorites = userFavourites;
	}

	public FavoriteDaoCollectionImpl() {
		if(userFavorites==null) {
			userFavorites = new LinkedHashMap<>();
		}
	}
	
	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@Override
	public void addFavorite(String userId, long movieId){
		LOGGER.info("Start");
		// TODO Auto-generated method stub
		Movie movie = movieDao.getMovie(movieId);
		if(userFavorites.containsKey(userId)) {
			LOGGER.info("if");
			Favorite favourite = userFavorites.get(userId);
			List<Movie> movieList = favourite.getFavoriteList();
			movieList.add(movie);
			favourite.setFavoriteList(movieList);
			userFavorites.put(userId, favourite);
		}else {
			LOGGER.info("else");
			Favorite favourite = new Favorite(new ArrayList<Movie>(), 0);
			List<Movie> list = favourite.getFavoriteList();
			list.add(movie);
			favourite.setFavoriteList(list);
			userFavorites.put(userId, favourite);
			System.out.println(favourite);
		}
		System.out.println(movie);
		
		//LOGGER.debug("added movie {} : "+movie);
		LOGGER.info("end");
	}

	@Override
	public void removeFavorite(String userId, long movieId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		Favorite favorite = userFavorites.get(userId);
		if(favorite == null ) {
			throw new FavoriteEmptyException();
		}
		List<Movie> list = favorite.getFavoriteList();
		if (list == null || list.size() < 1)
			throw new FavoriteEmptyException();
			for(Movie movie : list) {
				if(movie.getId() == movieId) {
					list.remove(movie);
					break;
				}
			}
			favorite.setFavoriteList(list);
		}
	
	@Override
	public Favorite getAllFavorites(String userId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		Favorite favorite = userFavorites.get(userId);
		List<Movie> allFavorites = favorite.getFavoriteList();
		if(favorite == null || allFavorites.isEmpty() || allFavorites.size()<1)
			throw new FavoriteEmptyException();
		else
			favorite.setCount(allFavorites.size());
		return favorite;
	}

}

