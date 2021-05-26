<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>" />
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
    <p>当出来方法返回ModelAndView实现forward</p>
    <form action="doForward.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <br>
    <p>当出来方法返回ModelAndView实现redirect</p>
    <form action="doRedirect.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
