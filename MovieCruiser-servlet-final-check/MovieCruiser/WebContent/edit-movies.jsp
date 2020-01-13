<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Movies</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie-logo-dark.png"> 
		<a href="ShowMoviesListAdmin">Movies</a>
	</div>
	<div class="align">
		<h1>Edit Movie</h1>
		<div class="body-content-colour">
			<form action="EditMovies" onsubmit="return validateMoviesForm()"
				name="editMovie" method="post">
				<div class="form-field-spacing">
					<label for="title">Title</label><br> <input type="text"
						class="text-box text-box-title" name="title" id="title"
						value="${movies.title}">
				</div>
				<br> <br>
				<div class="second">
					<div class="form-field-spacing">
						<label for="gross">Gross($)</label> <input type="text"
							class="text-box" name="gross" id="gross" value="${movies.gross}">
					</div>
					<div class="form-field-spacing">
						<label for="active">Active</label><br> <input class="radio"
							type="radio" name="active" value="yes"
							<c:if test="${movies.active}"> checked</c:if>>Yes <input
							class="radio" type="radio" name="active" value="no"
							<c:if test="${!movies.active}"> checked</c:if>>No
					</div>
					<div class="form-field-spacing">
						<label for="dateOfLaunch">Date of Launch</label><br> <input
							type="text" name="dateOfLaunch" class="text-box"
							value="<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${movies.dateOfLaunch}'/>">
					</div>
					<div class="form-field-spacing">
						<label for="genre">Genre</label><br> <select name="genre"
							class="dropdown">
							<option value="${movies.genre}">${movies.genre}</option>
							<option value="Science Fiction">Science Fiction</option>
							<option value="Superhero">Superhero</option>
							<option value="Romance">Romance</option>
							<option value="Comedy">Comedy</option>
							<option value="Adventure">Adventure</option>
							<option value="Thriller">Thriller</option>
						</select>
					</div>
				</div>
				<br>
				<div class="form-field-spacing">
					<input type="checkbox" name="teaser"
						<c:if test="${movies.teaser}">checked</c:if>> <label
						for="teaser">Has Teaser</label>
				</div>
				<br> <br>
				<div>
					<input type="hidden" name="id" value="${movies.id}"> <input
						type="submit" class="button success-button" value="Save">
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h3>Copyright &#169; 2019</h3>
	</div>
</body>
</html>