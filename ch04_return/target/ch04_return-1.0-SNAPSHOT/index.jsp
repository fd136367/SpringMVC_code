<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            //alert("按钮单击了！")
            $.ajax({
                //url:"returnVoid-ajax.do",
                url:"returnStudentJsonArray.do",
                data:{
                    name:"zhangsan",
                    age:2
                },
                type:"post",
                dataType:"json",
                success:function (response) {
                    //response从服务器返回的是json合适的字符串{"name":"zhangsan","age":20}
                    //jquery会把字符串转换称为json对象，赋值给respons
                    //alert(response.name + "    "+response.age)
                    $.each(response,(function (i,n) {
                        alert(n.name+"    "+n.age)
                    }))
                }
                })
        })
    })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString-view.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
<br>
<button id="btn">发起ajax请求</button>
</body>
</html>
