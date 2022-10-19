<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Max Chance -->
<meta charset="ISO-8859-1" />
<title>Add A Merge Tribe</title>
<link rel="icon" href="picture2.png" type="image/x-icon" />

<style>
body {
	background-image: url("picture9.png");
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
	padding-top: 27px;
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

form input[type="number"] {
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
	border-color: #ffdd7d;
	outline: none;
}

form select:focus {
	border-color: #ffdd7d;
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
	background: #ffdd7d;
	border-style: none;
	border-color: rgb(247, 212, 138);
	font-size: 20px;
	transition: all 0.6s ease;
	color: black;
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

</style>
</head>
<body>
<div class="container">
	<form action="addMergeTribeServlet" method="post" autocomplete="off">
		<p>Tribe Name:</p>
		<input required type="text" name="name" />

		<p>Name Meaning:</p>
		<input required type="text" name="meaning" />

		<p>Number Of Players:</p>
		<input required type="number" name="players" min="1" max="20" />

		<p>Available Seasons:</p>
		<select required name="seasonToAdd" size="6">
			<c:forEach items="${requestScope.allSeasons}" var="currentseason">
				<option value="${currentseason.seasonId}">${currentseason.seasonNum}
					&#11162 ${currentseason.seasonName}</option>
			</c:forEach>
		</select> <input type="submit" value="Add Tribe" />
	</form>
	</div>
	<br />
</body>
</html>