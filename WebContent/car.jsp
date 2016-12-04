<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<form action="ControlCar" method="post">
		ID <input type="text" name="carId" readonly="readonly" value='<c:out value="${car.id}"></c:out>'><br>
		Brand <input type="text" name="brand" value='<c:out value="${car.brand}"></c:out>'><br>
		Model <input type="text" name="model" value='<c:out value="${car.model}"></c:out>'><br>
		Website<input type="text" name="website" value='<c:out value="${car.website}"></c:out>'><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>