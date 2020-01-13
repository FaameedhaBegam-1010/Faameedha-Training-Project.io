<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<script src="js/script.js"></script>
<title>Cart</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="content">
		<h1>Cart</h1>
		<c:if test="${deleteCartStatus}">
		<div class="success-message">Item removed from Cart
			Successfully.</div>
	</c:if>
		<table>
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${cart.menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:setLocale value="en_In" /> <fmt:formatNumber
							type="currency" value="${menuItem.price}" /></td>
					<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><b>Total</b></td>
				<td><b>Rs.<fmt:formatNumber value="${cart.total}"
							pattern="#,##,##,##,###.00" />
				</b></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright &#169; 2019</h3>
	</div>
</body>
</html>