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

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="icon" href="picture2.png" type="image/x-icon" />

<title>View All Players</title>
</head>
<body>
	<h2 style="margin: 25px; text-align: center;">List of Players</h2>
	<div class="container">
		<form method="post" action="playersNavigationServlet">
			<table class="table table-striped table-hover">
				<tr>
					<th>Select</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age of Casting</th>
				</tr>
				<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
					<tr>
						<td><input required type="radio" name="id"
							value="${currentplayer.playerId}"></td>
						<td>${currentplayer.firstName}</td>
						<td>${currentplayer.lastName}</td>
						<td>${currentplayer.age}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="edit" name="doThisToPlayer"
				class="btn btn-warning"> <input type="submit" value="delete"
				name="doThisToPlayer" class="btn btn-danger"> <input
				type="submit" value="exit" name="doThisToPlayer"
				class="btn btn-info"> <a href="index.html"><input
				type="button" value="add" class="btn btn-success"></a>
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