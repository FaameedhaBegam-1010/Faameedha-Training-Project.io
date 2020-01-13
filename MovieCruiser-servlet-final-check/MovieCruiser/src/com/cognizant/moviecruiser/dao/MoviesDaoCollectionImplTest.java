package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Movies List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Movies List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "JodhaAkbar", 2750760348L, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("*** Modified Movies List ***");
		testGetMoviesListAdmin();
		Movies modified_item = moviesDao.getMovies(item.getId());
		System.out.println("Modified Movies Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}

}
