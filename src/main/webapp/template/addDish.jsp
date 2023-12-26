<%--
  Created by IntelliJ IDEA.
  User: ChiMi
  Date: 2023/12/27
  Time: 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>添加菜品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cantadmin_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dish.css">
</head>
<body>
<div class="dish-card">
    <c:if test="${requestScope.dish.image !=null}">
        <img src="res/${requestScope.dish.image}" alt="Dish Name">
    </c:if>
    <div class="dish-info">
        <form action="AddDish" method="post">
            <h3>菜品名称：
                <label>
                    <input type="text" name="name" value="">
                </label>
            </h3>
            <p>定价:
                <label>
                    <input type="number" name="price" value="">
                </label>
                元/份</p>
            <p>促销价:
                <label>
                    <input type="number" name="promptprice" value="">
                </label>
            </p>
            <p>菜系:
                <label>
                    <input type="text" name="type" value="">
                </label>
            </p>
            <input type="submit" class="button" value="添加菜品">
        </form>
    </div>
</div>
</body>
</html>
