package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoritesMovie(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(moviesId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMoviesList().add(movies);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> moviesList = new ArrayList<Movies>();
			moviesList.add(movies);
			favorites.setMoviesList(moviesList);
			userFavorites.put(userId, favorites);
		}
	}

	@Override
	public Favorites getAllFavoritesMovies(long userId) throws FavoritesEmptyException {
		Favorites favorites = userFavorites.get(userId);
		int total = 0;
		if (favorites == null || favorites.getMoviesList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<Movies> moviesList = favorites.getMoviesList();
		total += moviesList.size();
		favorites.setTotal(total);
		return favorites;
	}

	@Override
	public void removeFavoritesMovie(long userId, long moviesId) {
		List<Movies> moviesList = userFavorites.get(userId).getMoviesList();
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == moviesId) {
				moviesList.remove(i);
				return;
			}
		}
	}

}