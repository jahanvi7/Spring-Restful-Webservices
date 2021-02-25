package com.cognizant.moviecruiser.dao;

import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;

@Component
public interface FavoriteDao {

	public void addFavorite(String userId, long movieId) ;
	
	public void removeFavorite(String userId, long movieId) throws FavoriteEmptyException;
	
	public Favorite getAllFavorites(String userId) throws FavoriteEmptyException;
}

