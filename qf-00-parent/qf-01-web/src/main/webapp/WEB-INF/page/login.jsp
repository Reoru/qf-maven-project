<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/19 0019
  Time: 下午 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <h4>username:</h4> <input type="text" name="username"/><br/>
    <h4>password: </h4><input type="password" name="password"/><br/>
    <input type="checkbox" name="autoLogin"> remember me<br/>
    <input type="submit" value="login"/>

</form>
</body>
</html>
