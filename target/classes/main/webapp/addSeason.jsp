<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Add A Season</title>
<link rel="stylesheet" type="text/css" href="addSeasonStyle.css" />
</head>
<body>
	<form action="addSeasonServlet" method="post" autocomplete="off">
		<p>Season Number:</p>
		<input required type="number" name="number" min="1" max="42" />

		<p>Season Name:</p>
		<input required type="text" name="name" />

		<p>Season Winner:</p>
		<input required type="text" name="winner" />

		<p>First Aired On:</p>
		<input required type="date" name="date" /><br />

		<p>Available Players:</p>
		<select required name="allPlayersToAdd" size="6" multiple>
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.playerId}">${currentplayer.firstName}
					&#11162 ${currentplayer.lastName} &#11162 ${currentplayer.age}</option>
			</c:forEach>
		</select> <input type="submit" value="Add Season" />
	</form>
	<br />
	<a href="viewAllSeasonsServlet">View All Seasons</a>
</body>
</html>