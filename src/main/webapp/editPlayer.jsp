<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  </head>
  <body>
    <form action="editPlayerServlet" method="post" autocomplete="off">
      <p>New First Name</p>
      <input
        required
        type="text"
        name="fName"
        value="${playerToEdit.firstName}"
      />

      <p>New Last Name:</p>
      <input
        required
        type="text"
        name="lName"
        value="${playerToEdit.lastName}"
      />

      <p>New Cast Age:</p>
      <input
        required
        type="number"
        name="castAge"
        value="${playerToEdit.age}"
      />

      <input type="hidden" name="id" value="${playerToEdit.playerId}" />
      <input type="submit" value="Save" />
    </form>
  </body>
</html>