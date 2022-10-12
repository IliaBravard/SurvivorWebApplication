<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Edit a Season</title>
  </head>
  <body>
    <form action="editSeasonServlet" method="post" autocomplete="off">
      <p>New Season Number</p>
      <input
        required
        type="number"
        name="number"
        value="${seasonToEdit.seasonNum}"
      />

      <p>New Season Name:</p>
      <input
        required
        type="text"
        name="name"
        value="${seasonToEdit.seasonName}"
      />

      <p>New Season Winner:</p>
      <input
        required
        type="text"
        name="winner"
        value="${seasonToEdit.seasonWinner}"
      />

      <p>Update the Release Date:</p>
      <input
        required
        type="date"
        name="date"
        value="${seasonToEdit.firstAired}"
      />

      <input type="hidden" name="id" value="${seasonToEdit.seasonId}" />
      <input type="submit" value="Save" />
    </form>
  </body>
</html>