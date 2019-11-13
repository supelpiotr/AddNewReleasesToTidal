<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<body>

<%@ include file="/WEB-INF/header.jsp"%>

<%@ include file="/WEB-INF/topnav.jsp"%>

<div class="card">
    <h2>LOGIN</h2>
    <form:form method="post" modelAttribute="user">

        <div class="container">

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
</div>

</body>

</html>