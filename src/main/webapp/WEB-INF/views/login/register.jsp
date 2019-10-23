<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/header.jsp"%>

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
                    <form:input type="email" path="email" id="emailId" class="form-control"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-primary" value="Save">
            </div>
        </div>

    </div>
</form:form>
</body>
</html>