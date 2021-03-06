<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 04.03.2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<security:authorize access="isAuthenticated()">
    <security:authorize access="hasRole('ADMIN')">
        <h1><spring:message code="lbl.addTitle"/></h1>
        <form name="f" action="/add-order" method="post">
            <label><spring:message code="lbl.name"/></label>
            <input type="text" name="name">
            <label><spring:message code="lbl.price"/></label>
            <input type="text" name="price">
            <input type="submit" value="<spring:message code="lbl.buttonAdd"/>">
        </form>
    </security:authorize>
</security:authorize>
</body>
</html>

