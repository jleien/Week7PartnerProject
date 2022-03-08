<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Editor</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<form action = "editSetServlet" method="post">
Set Name: <input type ="text" name = "name" value= "${setToEdit.setName}">>
Number of Pieces: <input type = "text" name = "numPieces" value= "${setToEdit.numPieces}">>
Price: <input type = "text" name = "price" value= "${setToEdit.price}">>
Dimensions: <input type = "text" name = "dimensions" value= "${setToEdit.dimensions}">>

<input type = "hidden" name = "ID" value="${setToEdit.ID}">
<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>