<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20 0020
  Time: 上午 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>商品列表：</h1>
<c:forEach items="${goodsList}" var="goods" varStatus="status">
    <div>
            ${status.count} ---- > ${goods.name},${goods.description},${goods.price},${goods.category}
        <a href="${pageContext.request.contextPath}/goodsCar?m=add" id="addGoods">添加</a>

    </div>
    <br/>
</c:forEach>

<a href="${pageContext.request.contextPath}/goodsCar?m=my">前往我的购物车</a>
</body>

<script>


</script>
</html>