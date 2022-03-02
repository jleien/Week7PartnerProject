<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set List</title>
<link rel="stylesheet" href="lego.css">
</head>
<body>
<div>
	<form method="post" action="navigationServlet">

		<table>

			<c:forEach items="${requestScope.allSets}" var="currentset">
				<tr>
					<td><input type="radio" name="ID" value="${currentset.ID}"></td>
					<td>${currentset.setName}, </td>
					<td>${currentset.numPieces} pieces, </td>
					<td>$${currentset.price}.</td>
					<td>Dimensions: ${currentset.dimensions}</td>
				</tr>
			</c:forEach>
		</table>


		<input type="submit" value="edit" name="doThisToSet"> <input
			type="submit" value="delete" name="doThisToSet"> <input
			type="submit" value="add" name="doThisToSet">

	</form>
	
	<nav>
		<a href="index.html">Return Home</a>
	</nav>
	</div>
</body>
</html>