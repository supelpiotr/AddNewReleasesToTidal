<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <body>
    <div class="topnav">
        <ul>
            <a href="/home">Homepage</a>
            <sec:authorize access="!isAuthenticated()">
            <a class="float-right" href="/signin">Signin</a>
            <a class="float-right" href="/signup">Signup</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <li>
                <a class="float-right" href="/logout">Logout</a>
            </li>
            </sec:authorize>
        </ul>
    </div>
    </body>
</html>
