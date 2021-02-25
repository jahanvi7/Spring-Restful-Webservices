package com.cognizant.moviecruiser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteController.class);

	@Autowired
	private FavoriteService favoriteService;
	
	public FavoriteService getFavouriteService() {
		return favoriteService;
	}

	public void setFavouriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}

	@PostMapping("/{userId}/{movieId}")
	public void addFavorite(@PathVariable String userId,@PathVariable long movieId){
		LOGGER.info("Start");
		favoriteService.addFavorite(userId, movieId);
	}
	
	@GetMapping("/{userId}")
	public Favorite getAllFavorites(@PathVariable String userId) throws FavoriteEmptyException{
		return favoriteService.getAllFavorites(userId);
	}

	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavorite(@PathVariable String userId, @PathVariable long movieId) throws FavoriteEmptyException {
		favoriteService.removeFavorite(userId, movieId);
	}
}

