package com.cognizant.moviecruiser.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Favorite {

	private List<Movie> favoriteList;
	private int count;

	public List<Movie> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<Movie> favouriteList) {
		this.favoriteList = favouriteList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Favorite(List<Movie> favoriteList, int count) {
		super();
		this.favoriteList = favoriteList;
		this.count = count;
	}

	public Favorite() {
	}

	@Override
	public String toString() {
		return "Favorites [favoriteList=" + favoriteList + ", count=" + count + "]";
	}
}


