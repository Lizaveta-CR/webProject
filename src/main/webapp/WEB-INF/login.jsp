<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 14.03.2020
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<body onload='document.loginForm.username.focus();'>
<h1>Login Page</h1>

<c:if test="${not empty errorMessge}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
</c:if>

<form name='login' action="/login" method='POST'>
    <table>
        <tr>
            <td><spring:message code="lbl.loginName"/>:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.loginPass"/>:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name=
                                   <spring:message code="lbl.Submit"/> type="submit" value="submit"/></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
