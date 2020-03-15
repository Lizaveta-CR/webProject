<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 14.03.2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<hr/>
<h3>Admin Dashboard</h3>
<security:authorize access="isAuthenticated()">
    <b>Welcome!<security:authentication property="principal.username"/></b>
</security:authorize>
<br/>
<security:authorize access="isAuthenticated()">
    <a href="/order">Orders</a>|<a href="logout">Logout</a>
</security:authorize>
</body>
</html>
