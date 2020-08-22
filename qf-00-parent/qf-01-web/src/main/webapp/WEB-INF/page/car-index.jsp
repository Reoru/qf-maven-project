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
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script src="webjars/jquery/3.4.1/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<body>
<h1> ${sessionScope.userInfo.username}，欢迎!</h1>
<h1>购物车列表：</h1>
<c:if test="${not empty sessionScope.userInfo}">
    <c:forEach items="${sessionScope.userInfo.goodsList}" var="goods" varStatus="status">
        ${status.count} ---- > ${goods.name},${goods.description},${goods.price},${goods.category}
        <button onclick="delGoods('${goods.id}')" type="button" class="layui-btn layui-btn-primary">删除</button>
        <br/>
    </c:forEach>

    <button onclick="clears()" type="button" class="layui-btn layui-btn-primary">清空</button>
</c:if>

<c:if test="${empty sessionScope.userInfo}">
    <c:forEach items="${sessionScope.tempCar}" var="goods" varStatus="status">
        ${status.count} ---- > ${goods.name},${goods.description},${goods.price},${goods.category}
        <button onclick="delGoods('${goods.id}')" type="button" class="layui-btn layui-btn-primary">删除</button>
        <br/>
    </c:forEach>
    <button onclick="clears()" type="button" class="layui-btn layui-btn-primary">清空</button>
</c:if>

</body>

<script>
    function delGoods(id) {
        $.get("${pageContext.request.contextPath}/goodsCar?m=del&id=" + id, function () {
            // 删除成功刷新当前页面
            location.reload();
        });
    }

    function clears() {
        $.get("${pageContext.request.contextPath}/goodsCar?m=clear", function () {
            location.reload();
        });
    }

</script>
</html>
