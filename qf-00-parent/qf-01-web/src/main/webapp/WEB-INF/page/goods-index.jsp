<%@ page import="com.qf.constant.PropertyConst" %>
<%@ page import="java.util.ArrayList" %>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script src="webjars/jquery/3.4.1/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<body>
<h1> ${sessionScope.userInfo.username}，欢迎!</h1>

<h1>商品列表：</h1>
<c:forEach items="${sessionScope.goodsList}" var="goods" varStatus="status">
    <div>
            ${status.count} ----
        > ${goods.value.name},${goods.value.description},${goods.value.price},${goods.value.category}

        <button onclick="addGoods('${goods.value.id}')" type="button" class="layui-btn layui-btn-primary">添加</button>
    </div>
    <br/>
</c:forEach>

<button id="car" type="button" class="layui-btn layui-btn-primary" hidden>我的购物车</button>
<button onclick="window.location.href='${pageContext.request.contextPath}/go'" type="button"
        class="layui-btn layui-btn-primary" hidden>去登陆
</button>
</body>

<script>


    // 每次点击添加，则将商品添加至数组
    let goodsArr = [];

    function addGoods(id) {
        // 向后台发送ajax请求
        $.get("${pageContext.request.contextPath}/goodsCar?m=add&id=" + id);
    }

    $("#car").click(function () {
        window.location.href = "${pageContext.request.contextPath}/goodsCar?m=show";
    });

</script>
</html>
