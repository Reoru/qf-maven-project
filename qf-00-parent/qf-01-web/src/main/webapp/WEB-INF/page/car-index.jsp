<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20 0020
  Time: 上午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>购物车列表：</h1>
<c:forEach items="${sessionScope.tempCar}" var="goods" varStatus="status">
    ${status.count} ---- > ${goods.name},${goods.description},${goods.price},${goods.category}  <br/>
</c:forEach>
</body>
</html>
