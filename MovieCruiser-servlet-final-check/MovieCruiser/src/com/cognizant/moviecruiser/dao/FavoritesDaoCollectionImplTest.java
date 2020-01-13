package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoritesMovie() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoritesMovie(1, 2L);
		favoritesDao.addFavoritesMovie(1, 5L);
		favoritesDao.addFavoritesMovie(2, 1L);
		favoritesDao.addFavoritesMovie(2, 3L);
		Favorites moviesListCustomer = favoritesDao.getAllFavoritesMovies(1);
		System.out.println("User added Favorites List for Checkout");
		for (Movies movies : moviesListCustomer.getMoviesList()) {
			System.out.println(movies);
		}
		System.out.println("No of Favorites:" + moviesListCustomer.getMoviesList());
	}

	public static void testRemoveFavoritesMovie() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Movies List for Customer after Remove");
		try {
			favoritesDao.removeFavoritesMovie(1, 2L);
			favoritesDao.removeFavoritesMovie(1, 3L);
			Favorites moviesListCustomer = favoritesDao.getAllFavoritesMovies(1);
			for (Movies movies : moviesListCustomer.getMoviesList()) {
				System.out.println(movies);
			}
			System.out.println("No of Favorites:" + moviesListCustomer.getMoviesList());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoritesMovies() {
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovie();
		testRemoveFavoritesMovie();
	}

}
