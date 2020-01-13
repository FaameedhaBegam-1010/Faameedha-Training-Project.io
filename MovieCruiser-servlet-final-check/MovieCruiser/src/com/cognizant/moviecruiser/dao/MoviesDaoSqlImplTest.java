package com.cognizant.moviecruiser.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {
	public static void testgetMoviesListAdmin() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		String active;
		String teaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), teaser);
			System.out.println();
		}
	}

	public static void testgetMoviesListCustomer() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		String active;
		String teaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), teaser);
			System.out.println();
		}
	}

	public static void testmodifyMovies() {
		Movies movies = new Movies(1l, "Fida", 1234567890l, true, new DateUtil().convertToDate("10/10/2020"), "Romance",
				true);

		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();

		moviesDaoSqlImpl.modifyMovies(movies);
	}

	public static void main(String[] args) {
		testgetMoviesListAdmin();
		testgetMoviesListCustomer();
		testmodifyMovies();
		testgetMoviesListAdmin();
	}
}
