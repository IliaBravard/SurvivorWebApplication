<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!--
	Author: Max Chance
	Date: 10/12/2022
	Course: Advanced Java Programming
 -->

<html>
<head>
<meta charset="ISO-8859-1" />
<title>Edit a Player</title>
<link rel="icon" href="picture2.png" type="image/x-icon" />
<style>
body {
	background-image: url("picture8.png");
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
	padding-top: 75px;
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
	border-color: #f77eff;
	outline: none;
}

form input[type="submit"] {
	border: 0;
	margin-left: 9px;
	text-align: center;
	border: 2px solid white;
	background: transparent;
	width: 200px;
	padding: 14px 10px;
	color: white;
	font-size: 15px;
	border-radius: 25px;
	cursor: pointer;
	margin-top: 45px;
}

form input[type="submit"]:hover {
	background: #f77eff;
	border-style: none;
	border-color: rgb(247, 212, 138);
	font-size: 20px;
	transition: all 0.6s ease;
	color: black;
}
</style>

</head>
<body>
<div class = "container">
	<form action="editPlayerServlet" method="post" autocomplete="off">
		<p>New First Name</p>
		<input required type="text" name="fName"
			value="${playerToEdit.firstName}" />

		<p>New Last Name:</p>
		<input required type="text" name="lName"
			value="${playerToEdit.lastName}" />

		<p>New Cast Age:</p>
		<input required type="number" name="castAge"
			value="${playerToEdit.age}" /> <input type="hidden" name="id"
			value="${playerToEdit.playerId}" /> <input type="submit"
			value="Save" />
	</form>
	</div>
</body>
</html>