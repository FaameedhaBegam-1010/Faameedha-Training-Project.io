<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="align">
		<h1>Edit Menu Item</h1>
		<div class="body-content-colour">
			<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
				name="menuItemForm" method="post">
				<div class="form-field-spacing">
					<label for="name">Name</label><br> <input type="text"
						class="text-box text-box-title" name="name" id="name"
						value="${menuItem.name}">
				</div>
				<br> <br>
				<div class="second">
					<div class="form-field-spacing">
						<label for="price">Price(Rs.)</label><br> <input type="text"
							class="text-box" name="price" id="price"
							value="${menuItem.price}">
					</div>
					<div class="form-field-spacing">
						<label for="active">Active</label><br> <input class="radio"
							type="radio" name="active" value="yes"
							<c:if test="${menuItem.active}"> checked</c:if>>Yes <input
							class="radio" type="radio" name="active" value="no"
							<c:if test="${!menuItem.active}"> checked</c:if>>No
					</div>
					<div class="form-field-spacing">
						<label for="dateOfLaunch">Date of Launch</label><br> <input
							class="text-box" name="dateOfLaunch"
							value="<fmt:formatDate type="date"  pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}"/>">
					</div> 
					<div class="form-field-spacing">
						<label for="category">Category</label><br> <select
							name="category" class="dropdown">
							<option value="${menuItem.category }">${menuItem.category}</option>
							<option value="Starters">Starters</option>
							<option value="Main Course">Main Course</option>
							<option value="Dessert">Dessert</option>
							<option value="Drinks">Drinks</option>
						</select>
					</div>
					<br> <br>
				</div>
				<div class="form-field-spacing">
					<input type="checkbox" name="freeDelivery"
						<c:if test="${menuItem.freeDelivery}">checked</c:if>> <label
						for="freeDelivery">Free Delivery</label>
				</div>
				<br> <br>
				<div>
					<input type="hidden" name="id" value="${menuItem.id}"> <input
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