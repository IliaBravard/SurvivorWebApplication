<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Allows for the use of the JSTL tag library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
 	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
        <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="icon" href="picture2.png" type="image/x-icon" />
        <title>View All Seasons</title>
        
  </head>
  <body>
    <div class="container">
  <h2 style="margin: 25px; text-align: center;">List of Seasons</h2>
    <form method = "post" action = "seasonsNavigationServlet">
    <table class="table table-striped table-hover">
    <tr>
        <th>Select</th>
        <th>Season #</th>
        <th>Seasons Name</th>
        <th>Winner</th>
        <th>Released On</th>
      </tr>
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
    <input type = "submit" value = "edit" name="doThisToSeason" class="btn btn-warning">
    <input type = "submit" value = "delete" name="doThisToSeason" class="btn btn-danger">
    <a href = "index.html"><input type = "button" value = "add" class="btn btn-success"></a>
    <input type = "button" value = "exit" class="btn btn-info">
    </form>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </div>
  </body>
</html>
