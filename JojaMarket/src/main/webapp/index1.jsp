<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Welcome to Joja Market</title>
<meta charset="UTF-8"/>
</head>
<body>
<h2>Welcome to Joja Market</h2>
<a href="hello">hello</a>
<h3>RequestMapping测试</h3>
<a href="handle01">test01-写在方法上的RequestMapping</a>
<a href="haha/handle01">test01-写在类上的RequestMapping</a>
<h3>RequestMapping属性测试</h3>
<a href="haha/handle02">test02-method参数</a>
<form action="haha/handle02" method="post">
    <input type="submit" value="handle02 post"/>
</form>
<hr>
<a href="haha/handle03">test03-params参数</a>
<a href="haha/handle03?username=pangtou">test03-params参数 username</a>
<a href="haha/handle031?username=pangtou">test03-params参数 !username</a>
<hr>
<a href="haha/handle04">test04-headers参数</a>
<hr>
<h3>RequestMapping-Ant风格的URL</h3>
<a href="antTest01">精确-antTest01</a>
<a href="antTest02">模糊-antTest02</a>
<hr>
<h3>RequestMapping-PathVariable</h3>
<a href="antTest05/aa/">PathVariable-antTest05</a>
</body>
</html>
