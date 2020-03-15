<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 14.03.2020
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Shop Page</title>
</head>
<body>
<a href="/?lang=en">English</a> | <a href="/?lang=ru">Русский</a>
<h3>
    <security:authorize access="isAnonymous()"><spring:message code="lbl.indexTitle"/></security:authorize>
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username"/>
    </security:authorize>
</h3>
<security:authorize access="isAnonymous()">
    <spring:message code="lbl.loginas"/> <a href="user"> <spring:message
        code="lbl.user"/></a>|<a href="/admin"><spring:message code="lbl.admin"/></a>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <security:authorize access="hasRole('USER')">
        <a href="user"><spring:message code="lbl.myprofile"/></a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a href="admin"><spring:message code="lbl.myprofile"/></a>
    </security:authorize>
    <a href="logout"><spring:message code="lbl.logout"/></a>
</security:authorize>
<p><spring:message code="lbl.currentLocale"/>:${pageContext.response.locale}</p>
</body>
</html>
