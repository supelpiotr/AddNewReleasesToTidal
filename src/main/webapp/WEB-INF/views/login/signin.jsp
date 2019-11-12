<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Grayscale - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/grayscale.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<%@ include file="/WEB-INF/views/navigationbar.jsp"%>

<!-- Header -->
<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">REGISTER</h1>
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
        </div>
    </div>
</header>

<!-- Footer -->
<footer class="bg-black small text-center text-white-50">
    <div class="container">
        Copyright &copy; MyMusicList 2019
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="resources/js/grayscale.min.js"></script>

</body>

</html>