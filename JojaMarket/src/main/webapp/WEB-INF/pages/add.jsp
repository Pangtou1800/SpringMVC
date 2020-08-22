<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Pangtou1404
  Date: 2020/8/20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>Welcome to Joja Market</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>员工添加</h1>
    </div>
    <form:form action="${ctp}/emp" method="post" modelAttribute="newEmp">
        <input type="hidden" name="_method" value="POST"/>
        <div class="form-group">
            <label>LastName</label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName"/>
        </div>
        <div class="form-group">
            <label>E-mail</label>
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email"/>
        </div>
        <div class="form-group">
            <label>Gender</label>
            <div>
                <label class="radio-inline">
                    <form:radiobutton path="gender" value="0"/>
                    <span>男</span>
                </label>
                <label class="radio-inline">
                    <form:radiobutton path="gender" value="1"/>
                    <span>女</span>
                </label>
            </div>
        </div>
        <div class="form-group">
            <label>Birthday</label>
            <form:input path="birth" cssClass="form-control"/>
            <form:errors path="birth"/>
        </div>
        <div class="form-group">
            <label>Department</label>
            <form:select path="department.id" items="${departs}" itemLabel="departmentName"
                         itemValue="id" cssClass="form-control"/>
        </div>
        <button type="submit" class="btn btn-default">添加</button>
    </form:form>
</div>
</body>
</html>
