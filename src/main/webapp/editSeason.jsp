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
<meta charset="ISO-8859-1" />
<title>Edit a Season</title>

<link rel="icon" href="picture2.png" type="image/x-icon" />

<style>
body {
	background-image: url("picture6.png");
	background-size: cover;
	background-repeat: no-repeat;
	font-family: "montserrat";
}

p {
	color: white;
	font-size: 20px;
}

.container {
	display: flex;
	justify-content: center;
	width: 300px;
	padding-left: 160px;
	padding-top: 5px;
}

form {
	text-align: center;
}

form input[type="text"] {
	border: 0;
	margin-left: 17px;
	text-align: center;
	border: 2px solid white;
	background: transparent;
	width: 300px;
	color: white;
	font-size: 18px;
	padding: 7px;
	border-radius: 25px;
	transition: 0.25s;
}

form input[type="number"], input[type="date"] {
	margin-left: 17px;
	padding: 7px;
	text-align: center;
	border: 2px solid white;
	background: transparent;
	width: 240px;
	color: white;
	font-size: 18px;
	border-radius: 25px;
	transition: 0.25s;
}

form input[type="text"]:focus, form input[type="number"]:focus {
	width: 320px;
	border-color: rgb(144, 229, 115);
	outline: none;
}

form input[type="date"]:focus, select:focus {
	border-color: rgb(144, 229, 115);
	outline: none;
}

form input[type="submit"] {
	border: 0;
	margin: 15px auto;
	text-align: center;
	border: 2px solid white;
	background: transparent;
	width: 200px;
	padding: 14px 10px;
	color: white;
	font-size: 15px;
	border-radius: 25px;
	cursor: pointer;
}

form input[type="submit"]:hover {
	background: #ac9187;
	border-style: none;
	border-color: rgb(247, 212, 138);
	font-size: 20px;
	transition: all 0.6s ease;
	color: white;
}

form select {
	color: white;
	border: 2px solid white;
	background-color: transparent;
	border-radius: 10px;
	decoration: none;
	width: 165px;
	font-size: 13px;
	overflow-y: auto;
	text-align: center;
}

::-webkit-calendar-picker-indicator {
	filter: invert(1);
}
</style>

</head>
<body>
	<div class="container">
		<form action="editSeasonServlet" method="post" autocomplete="off">
			<p>New Season Number</p>
			<input required type="number" name="number"
				value="${seasonToEdit.seasonNum}" />

			<p>New Season Name:</p>
			<input required type="text" name="name"
				value="${seasonToEdit.seasonName}" />

			<p>New Season Winner:</p>
			<input required type="text" name="winner"
				value="${seasonToEdit.seasonWinner}" />

			<p>Update the Release Date:</p>
			<input required type="date" name="date"
				value="${seasonToEdit.firstAired}" /> <input type="hidden"
				name="id" value="${seasonToEdit.seasonId}" />

			<p>New Players:</p>
			<select required name="allPlayersToAdd" size="3" multiple>
				<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
					<option value="${currentplayer.playerId}">${currentplayer.firstName}
						${currentplayer.lastName} &#11162 ${currentplayer.age}</option>
				</c:forEach>
			</select> <br> <input type="submit" value="Save" />
		</form>
	</div>
</body>
</html>