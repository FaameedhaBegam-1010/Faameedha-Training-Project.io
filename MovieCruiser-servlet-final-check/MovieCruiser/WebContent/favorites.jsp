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
		<img src="images/movie-logo-dark.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<div class="content">
		<h1>Favorites</h1>
		<c:if test="${deleteFavoritesStatus}">
			<div class="success-message">Movie removed from Favorites
				Successfully.</div>
		</c:if>
		<table id="table_id">
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<c:forEach items="${favorites.moviesList}" var="movies">
					<tr>
						<td>${movies.title}</td>
						<td>$<fmt:formatNumber type="number" value="${movies.gross}" /></td>
						<td>${movies.genre}</td>
						<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>
					</tr>
				</c:forEach>
			<tr>
				<td></td>
				<td><b>No. of Favorites</b></td>
				<td><b>${favorites.total} </b></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright &#169; 2019</h3>
	</div>
</body>
</html>