<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>提交参数给Controller</p>
    <form action="receiveProperty.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <br>
    <p>不传参</p>
    <form action="receiveparam.do" method="post">
        姓名:<input type="text" name="rname">
        年龄:<input type="text" name="rage">
        <input type="submit" value="提交参数">
    </form>
<br>
    <p>对象接收参数</p>
    <form action="receiveobject.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
