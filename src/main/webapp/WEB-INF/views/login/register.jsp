<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/header.jsp"%>

<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<form:form method="post" modelAttribute="user">

    <div class="container">

        <h3 class="header">Add user</h3>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="firstNameId">First Name:</label>
                    <form:input type="text" path="firstName" id="firstNameId" class="form-control"/>
                    <form:errors path="firstName" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="lastNameId">Last Name:</label>
                    <form:input type="text" path="lastName" id="lastNameId" class="form-control"/>
                    <form:errors path="lastName" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password" id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <form:input type="email" path="username" id="emailId" class="form-control"/>
                    <form:errors path="username" element="div" cssClass="error"/>
                </div>

            <%--<div class="form-group">
                    <label for="favouriteGenre">Favourite music genre:</label>
                    <form:input type="text" path="favouriteGenre" id="favouriteGenreId" class="form-control"/>
                    <form:errors path="favouriteGenre" element="div" cssClass="error"/>
                </div>--%>

                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>
