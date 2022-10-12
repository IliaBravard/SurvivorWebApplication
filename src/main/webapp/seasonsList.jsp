<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Allows for the use of the JSTL tag library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>View All Seasons</title>
  </head>
  <body>
    <form method = "post" action = "seasonsNavigationServlet">
    <table>
      <c:forEach items="${requestScope.allSeasons}" var="currentseason">
      <tr>
        <td><input required type="radio" name="id" value="${currentseason.seasonId}"></td>
        <td>${currentseason.seasonNum}</td>
        <td>${currentseason.seasonName}</td>
        <td>${currentseason.seasonWinner}</td>
        <td>${currentseason.firstAired}</td>
      </tr>
      </c:forEach>
    </table>
    <input type = "submit" value = "edit" name="doThisToSeason">
    <input type = "submit" value = "delete" name="doThisToSeason">
    <a href = "addSeason.html"><input type = "button" value = "add"></a>
    </form>
  </body>
</html>
