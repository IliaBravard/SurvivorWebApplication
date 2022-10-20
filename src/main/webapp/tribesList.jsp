<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!--
	Author: Ilia Bravard - igbravard
	Date: 10/20/2022
	Course: Advanced Java Programming
 -->

<html>
<head>
<meta charset="UTF-8">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<link rel="icon" href="picture2.png" type="image/x-icon" />

<title>View All Tribes</title>

</head>
<body>
	<div class="container">
		<h2 style="margin: 25px; text-align: center;">List of Tribes</h2>
		<form method="post" action="tribesNavigationServlet">
			<table class="table table-striped table-hover">
				<tr>
					<th>Select</th>
					<th>Tribe Name</th>
					<th>Name Meaning</th>
					<th>Number of Players</th>
					<th>Season</th>
				</tr>
				<c:forEach items="${requestScope.allTribes}" var="currenttribe">
					<tr>
						<td><input required type="radio" name="id"
							value="${currenttribe.tribeId}"></td>
						<td>${currenttribe.tribeName}</td>
						<td>${currenttribe.meaning}</td>
						<td>${currenttribe.numOfPlayers}</td>
						<td>${currenttribe.season}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="delete" class="btn btn-danger"
				name="doThisToTribe"> <input type="submit" value="exit"
				class="btn btn-info" name="doThisToTribe"> <a
				href="index.html"><input type="button" value="add"
				class="btn btn-success"></a>
		</form>

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>