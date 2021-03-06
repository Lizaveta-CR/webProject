<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 28.02.2020
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%--????--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h1><spring:message code="lbl.page"/></h1>
<security:authorize access="isAuthenticated()">
    <security:authorize access="hasRole('USER')">
        <table>
            <tr>
                <th><spring:message code="lbl.name"/></th>
                <th><spring:message code="lbl.price"/></th>
                <th><spring:message code="lbl.action"/></th>
            </tr>
            <c:forEach var="order" items="${ordersList}">
                <tr>
                    <td>${order.name}</td>
                    <td>${order.price}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/"><spring:message code="lbl.home"/></a>|<a href="logout"><spring:message code="lbl.logout"/></a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <table>
            <tr>
                <th><spring:message code="lbl.name"/></th>
                <th><spring:message code="lbl.price"/></th>
                <th><spring:message code="lbl.action"/></th>
            </tr>
            <c:forEach var="order" items="${ordersList}">
                <tr>
                    <td>${order.name}</td>
                    <td>${order.price}</td>
                    <td><a href="/delete/${order.id}"><spring:message code="lbl.delete"/></a></td>
                    <td><a href="/edit-order/${order.id}"><spring:message code="lbl.edit"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/add-order"><spring:message code="lbl.add"/></a>
        <a href="/"><spring:message code="lbl.home"/></a>|<a href="logout"><spring:message code="lbl.logout"/></a>
    </security:authorize>
</security:authorize>
</body>
</html>
