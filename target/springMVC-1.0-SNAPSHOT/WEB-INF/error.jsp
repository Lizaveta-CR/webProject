<%--
  Created by IntelliJ IDEA.
  User: elizaveta
  Date: 06.03.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title><spring:message code="lbl.errorPage"/></title>
</head>
<body>
<spring:message code="lbl.errorMessage"/>
<a href="/"> <spring:message code="lbl.errorExit"/></a>
</body>
</html>
