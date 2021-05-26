<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/26
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    退出系统，从session中删除数据
    <%
        session.removeAttribute("name");
    %>
</body>
</html>
