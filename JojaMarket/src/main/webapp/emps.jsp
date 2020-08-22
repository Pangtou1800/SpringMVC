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

    <a href="#" class="btn btn-default">Ajax获取所有员工</a>
    <%=new java.util.Date()%>
    <div id="allEmps"></div>

    <hr>
    <%--    <form action="testRequestBody" method="post">--%>
    <form action="ajaxTest01" method="post">
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
        <button type="submit" class="btn btn-default">添加</button>
    </form>
    <hr>

    <a id="sendBtn" href="#" class="btn btn-default">Ajax发送员工信息</a>

    <script>
        $("a:first").click(function () {
            $.ajax({
                url: "${ctp}/getAll",
                type: "GET",
                success: function (data) {
                    // console.log(data);
                    $.each(data, function () {
                        var empInfo = this.lastName + " " + this.birth + " " + this.gender + "<br/>";
                        $("#allEmps").append(empInfo);
                    });
                }
            });
            return false;
        });

        $("#sendBtn").click(function () {
            var emp = {
                lastName: "mary",
                email: "mary@joja.com",
                gender: 0
            };
            var empStr = JSON.stringify(emp);
            $.ajax({
                url: "${ctp}/testRequestBody01",
                type: "POST",
                contentType: "application/json",
                data: empStr,
                success: function (data) {
                    alert(data);
                }
            });
            return false;
        });

    </script>

</div>
</body>
</html>
