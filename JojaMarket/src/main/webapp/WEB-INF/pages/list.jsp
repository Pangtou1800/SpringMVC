<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>员工列表</h1>
    </div>
    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>E-mail</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender == 0 ? "男" : "女"}</td>
                <td>${emp.department.departmentName}</td>
                <td><a href="${ctp}/emp/${emp.id}" class="btn btn-default">&nbsp;Edit&nbsp;</a></td>
                <td>
                    <a href="${ctp}/emp/${emp.id}" class="btn btn-default delBtn">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${ctp}/toAddPage" class="btn btn-default">添加员工</a>
    <form id="deleteForm" action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>
    <script>
        $(function() {
            $(".delBtn").click(function() {
                $("#deleteForm").attr("action", this.href);
                $("#deleteForm").submit();
                return false;
            })
        });
    </script>
</div>
</body>
</html>
