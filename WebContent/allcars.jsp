<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All cars</title>
</head>
<body>
	<table style="border:1px solid black">
		<tr>
			<th>ID</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Website</th>
			<th colspan="2">Actions</th>
		</tr>

		<c:forEach var="car" items="${cars}">
			<tr>
				<td><c:out value="${car.id}"></c:out></td>
				<td><c:out value="${car.brand}"></c:out></td>
				<td><c:out value="${car.model}"></c:out></td>
				<td><a href ="<c:out value="${car.website}"/>"><c:out value="${car.website}"/></a></td>
				<td><a href ="ControlCar?action=update&carId=<c:out value="${car.id}"/>">Update</a></td>
				<td><a href ="ControlCar?action=delete&carId=<c:out value="${car.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="index.html">Index</a>
	</p>
</body>
</html>