<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>Welcome to Joja Market</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>Welcome to Joja Market</h2>
<a href="interceptor01">拦截器</a>
<a href="exception01?i=0">错误01</a>
<a href="exception02?username=admin">错误02</a>
<a href="exception03?username=admin">错误03</a>
<hr>
<h3>${message}</h3>
<form action="${ctp}/uploadFile" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerImg"/><br/>
    用户头像2：<input type="file" name="headerImg"/><br/>
    用户名：<input type="text" name="username"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
