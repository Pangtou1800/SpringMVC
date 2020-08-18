<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Welcome to Joja Market</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h2>Welcome to Joja Market</h2>
    </div>

    <hr>
    <form action="output01" method="post">
        <input class="btn btn-default" type="submit" value="带数据"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="output02" method="post">
        <input class="btn btn-default" type="submit" value="带数据2"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="output03" method="post">
        <input class="btn btn-default" type="submit" value="带数据3"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="output04" method="post">
        <input class="btn btn-default" type="submit" value="带数据4"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="output05" method="post">
        <input class="btn btn-default" type="submit" value="带数据5"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="modelAttribute01" method="post">
        <input type="hidden" name="id" value="ISBN-001"/>
        书名：西游记<br/>
        作者：吴承恩<br/>
        价格：<input type="text" name="price" value="18.7"/><br/>
        库存：<input type="text" name="stock" value="15"/><br/>
        销量：<input type="text" name="sales" value="14"/><br/>
        <input class="btn btn-default" type="submit" value="带数据6"/>
        <input type="hidden" name="_method" value="POST"/>
    </form>
    <hr>

    <!--
     /book/1 GET    查询
     /book/1 DELETE 删除
     /book/1 PUT    更新
     /book   POST   添加
     -->
    <form action="book/1" method="post">
        <input class="btn btn-default" type="submit" value="查询图书"/>
        <input type="hidden" name="_method" value="GET"/>
    </form>
    <form action="book" method="post">
        <input class="btn btn-default" type="submit" value="添加图书"/>
        <input type="hidden" name="_method" value="POST"/>
    </form>
    <form action="book/1" method="post">
        <input class="btn btn-default" type="submit" value="删除图书"/>
        <input type="hidden" name="_method" value="DELETE"/>
    </form>
    <form action="book/1" method="post">
        <input class="btn btn-default" type="submit" value="更新图书"/>
        <input type="hidden" name="_method" value="PUT"/>
    </form>

    <a href="handle01?username=pangtou">Handle01</a>
    <br/>
    <a href="handle02?username=pangtou">Handle02</a>
    <br/>
    <a href="handle03">Handle03</a>
    <br/>
    <a href="handle04">Handle04</a>
    <br/>
    <a href="handle05">Handle05</a>

    <hr>

    <form action="book" method="post">
        书名：<input type="text" name="bookName"/><br>
        作者：<input type="text" name="author"/><br>
        价格：<input type="text" name="price"/><br>
        库存：<input type="text" name="stock"/><br>
        销量：<input type="text" name="sales"/><br>
        省：<input type="text" name="address.province"/><br>
        市：<input type="text" name="address.city"/><br>
        街道：<input type="text" name="address.street"/><br>
        <input class="btn btn-default" type="submit" value="添加图书"/>
        <input type="hidden" name="_method" value="POST"/>
    </form>
</div>
</body>
</html>
