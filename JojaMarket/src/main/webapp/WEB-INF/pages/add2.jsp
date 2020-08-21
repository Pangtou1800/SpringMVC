<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Pangtou1404
  Date: 2020/8/20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="emp" method="post">
        <input type="hidden" name="_method" value="POST"/>
        <div class="form-group">
            <label>LastName</label>
            <input type="text" name="lastName" class="form-control"/>
        </div>
        <div class="form-group">
            <label>E-mail</label>
            <input type="email" name="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Gender</label>
            <br/>
            <label class="radio-inline">
                <input type="radio" name="gender" value="0"/>
                <span>男</span>
            </label>
            <label class="radio-inline">
                <input type="radio" name="gender" value="1"/>
                <span>女</span>
            </label>
        </div>
        <div class="form-group">
            <label>Department</label>
            <select name="department.id" class="form-control">
                <c:forEach items="${departs}" var="depart">
                    <option value="${depart.id}">${depart.departmentName}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-default">添加</button>
    </form>
</div>
</body>
</html>
