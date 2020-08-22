<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2020/8/20
  Time: 10:17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods?m=edit" method="post">
    <input type="hidden" name="id" value="${requestScope.goodsInfo.id}">
    名称：<input type="text" name="name" value="${requestScope.goodsInfo.name}"></br>
    描述： <input name="description" type="text" value="${requestScope.goodsInfo.description}"><br/>
    价格：<input type="text" name="price" value="${requestScope.goodsInfo.price}"></br>
    商品类别：
    <select name="cid">
        <c:forEach items="${requestScope.categoryList}" var="category">
            <c:choose>
                <c:when test="${category.id==requestScope.goodsInfo.cid}">
                    <option name="cid" selected="selected" value="${category.id}">${category.name}</option>
                </c:when>
                <c:otherwise>
                    <option name="cid" value="${category.id}">${category.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
