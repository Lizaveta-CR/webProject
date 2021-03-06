<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 04.03.2020
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Edit order</title>
</head>
<body>
<div align="center">
    <h2><spring:message code="lbl.editPage"/></h2>
    <form:form action="/edit-order" method="post" modelAttribute="order">
        <table border="0" cellpadding="5">
            <tr>
                <td><spring:message code="lbl.name"/></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.price"/></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="<spring:message code="lbl.editButton"/>"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>