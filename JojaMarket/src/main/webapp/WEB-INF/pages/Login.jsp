<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Pangtou1404
  Date: 2020/8/20
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Welcome to Joja Market</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1><fmt:message key="welcomeInfo"/></h1>
<form action="#">
    <fmt:message key="username"/>:<input name="username" type="text"/>
    <fmt:message key="password"/>：<input name="password" type="password"/>
    <input type="submit" value="<fmt:message key='loginBtn'/>"/>
</form>
</body>
</html>