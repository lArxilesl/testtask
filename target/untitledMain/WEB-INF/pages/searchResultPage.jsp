<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Result Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div class="container">
<form class="pull-right" action="/back" method="get">
  <button type="submit" class="btn btn-primary">Back</button>
</form>
  <c:choose>
    <c:when test="${checker}">
      <h3 class="text-warning">Извините, имени "${name}" нет в списке. Введите заново имя </h3>
    </c:when>
    <c:otherwise>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Number</th>
          <th>Firstname</th>
          <th>Surname</th>
          <th>Admin?</th>
          <th>Age</th>
          <th>Date</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="m" varStatus="loop">

          <tr>
            <td>${loop.count}</td>
            <td>${m.name}</td>
            <td>${m.surname}</td>
            <c:choose>
              <c:when test="${m.admin}">
                <td>Yes</td>
              </c:when>
              <c:otherwise>
                <td>No</td>
              </c:otherwise>
            </c:choose>

            <td>${m.age}</td>
            <td>${m.date}</td>
          </tr>
        </c:forEach>

        </tbody>
      </table>
    </c:otherwise>
  </c:choose>

</div>
</body>
</html>
