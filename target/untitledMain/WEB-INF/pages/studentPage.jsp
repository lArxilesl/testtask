<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Student Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<div class="container">
    <form class="form-inline" action="/search" method="post">
        <div class="form-group">
            <label for="naeStudent">Name</label>
            <input type="text" class="form-control" id="naeStudent" placeholder="Search..." name="name">
        </div>
        <button type="submit" class="btn btn-warning">Search</button>
    </form>

    <c:choose>
        <c:when test="${change}">
            <form:form action="/update" method="post" modelAttribute="studentDto" >
                <div class="form-group">
                    <label for="name">Name:</label>
                    <form:input type="text" class="form-control hidden" id="name1" path="idStudent"/>
                    <form:input type="text" class="form-control" id="name" path="name"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <form:input type="text" class="form-control" id="surname" path="surname"/>
                </div>
                <div class="form-group">
                    <label for="surname">Age:</label>
                    <form:input type="number" class="form-control" id="age" path="age"/>
                </div>
                <div class="form-group">
                    <form:checkbox path="admin"/>Admin?
                </div>

                <button type="submit" class="btn btn-default">Update</button>
            </form:form>
        </c:when>
        <c:otherwise>
            <form:form action="/add" method="post" modelAttribute="studentDto" >
                <div class="form-group">
                    <label for="name">Name:</label>
                    <form:input type="text" class="form-control" id="name" path="name"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <form:input type="text" class="form-control" id="surname" path="surname"/>
                </div>
                <div class="form-group">
                    <label for="surname">Age:</label>
                    <form:input type="number" class="form-control" id="age" path="age"/>
                </div>
                <div class="form-group">
                    <form:checkbox path="admin"/>Admin?
                </div>
                <button type="submit" class="btn btn-default">Add</button>
            </form:form>
        </c:otherwise>
    </c:choose>

</div>


<!--  Read  -->
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Number</th>
            <th>Firstname</th>
            <th>Surname</th>
            <th>Admin?</th>
            <th>Age</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${studentsList}" var="m" varStatus="loop">

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
                <td>
                    <a href="/delete2/${m.idStudent}">
                        <button formmethod="get" class="btn btn-warning">Delete</button>
                    </a>
                    <a href="/update/${m.idStudent}">
                        <button formmethod="get" class="btn btn-danger">Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
