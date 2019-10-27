<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/header.jsp"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form:form method="post" modelAttribute="user">

    <div class="container">

        <h3 class="header">Logowanie</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="emailId">Login:</label>
                    <form:input type="text" path="username" id="emailId" class="form-control"/>
                    <form:errors path="username" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password" id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <c:if test="${loginFailed == true}">
                    <div class="error" style="padding-bottom: 20px">Nieprawidłowe dane</div>
                </c:if>
                <a href="/signup" class="btn btn-primary">Zarejestruj</a>

                <input type="submit" class="btn btn-primary" value="Login">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
