package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {

	public static void testaddFavoritesMovie() throws FavoritesEmptyException {
		long userId = 2l;
		new FavoritesDaoSqlImpl().addFavoritesMovie(userId, 2);
		testgetAllFavoritesMovies();
	}

	public static void testgetAllFavoritesMovies() throws FavoritesEmptyException {

		List<Movies> list = new ArrayList<>();
		long userId = 2l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = favoritesDaoSqlImpl.getAllFavoritesMovies(userId);
		list = favorites.getMoviesList();

		System.out.format("%-10s%-20s%-15s%-15s", "ID", "TITLE", "GROSS", "GENRE");
		for (Movies movies : list) {
			System.out.format("\n%-10s%-20s%-15s%-15s", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getGenre());
		}
		System.out.println("\nNo of Favorites :" + favorites.getTotal());
	}

	public static void testremoveFavoritesMovie() throws FavoritesEmptyException {
		long userId = 1l;
		new FavoritesDaoSqlImpl().removeFavoritesMovie(userId, 3);
		testgetAllFavoritesMovies();
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testaddFavoritesMovie();
		testgetAllFavoritesMovies();
		testremoveFavoritesMovie();
	}
}
