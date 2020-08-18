<%--
  Created by IntelliJ IDEA.
  User: Pangtou1404
  Date: 2020/8/16
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    访问成功！
    ${requestScope.requestAttr}
    ${sessionScope.sessionAttr}
    <hr>
    pageContext: ${pageScope.msg}<br/>
    request: ${requestScope.msg}<br/>
    request: ${requestScope.counter}<br/>
    session: ${sessionScope.msg}<br/>
    session: ${sessionScope.counter}<br/>
    application: ${applicationScope.msg}<br/>
</body>
</html>
