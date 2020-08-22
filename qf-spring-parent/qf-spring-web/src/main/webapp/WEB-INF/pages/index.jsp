<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21 0021
  Time: 上午 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<body>
<h1>Spring MVC Test</h1>
${requestScope.user.username}
<button type="button" id="btn" class="layui-btn layui-btn-normal layui-btn-radius">按钮</button>
</body>
<script>
    $(function(){
        $("#btn").click(function(){
            alert(222);
        });
    });

</script>
</html>
