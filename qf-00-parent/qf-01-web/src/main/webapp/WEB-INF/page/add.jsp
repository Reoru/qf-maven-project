<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2020/8/19
  Time: 22:15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form action="/addGoods" method="post">
    名称：<input type="text" name="name" ><br/>
    描述： <input name="description" type="text"><br/>
    价格：<input type="password" name="price"><br/>
    商品类别：
    <select name="categoryId">
        <c:forEach items="${categoryList}" var="category">
            <option name="categoryId" value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
