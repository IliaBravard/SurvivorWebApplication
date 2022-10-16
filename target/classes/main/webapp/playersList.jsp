<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Allows for the use of the JSTL tag library -->
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
    <title>View All Players</title>
  </head>
  <body>
    <form method = "post" action = "playersNavigationServlet">
    <table>
      <c:forEach items="${requestScope.allPlayers}" var="currentplayer">
      <tr>
        <td><input required type="radio" name="id" value="${currentplayer.playerId}"></td>
        <td>${currentplayer.firstName}</td>
        <td>${currentplayer.lastName}</td>
        <td>${currentplayer.age}</td>
      </tr>
      </c:forEach>
    </table>
    <input type = "submit" value = "edit" name="doThisToPlayer">
    <input type = "submit" value = "delete" name="doThisToPlayer">
    <a href = "addPlayer.html"><input type = "button" value = "add"></a>
    </form>
  </body>
</html>