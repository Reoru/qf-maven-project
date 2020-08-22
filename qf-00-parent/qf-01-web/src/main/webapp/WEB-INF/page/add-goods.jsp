<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20 0020
  Time: 下午 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods?m=add" method="post">
    名称：<input type="text" name="name"><br/>
    描述： <input name="description" type="text"><br/>
    价格：<input type="text" name="price"><br/>
    商品类别：
    <select name="cid">
        <c:forEach items="${requestScope.categoryList}" var="category">
            <option name="cid" value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
