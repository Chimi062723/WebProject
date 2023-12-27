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
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>编辑菜品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cantadmin_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dish.css">
</head>
<body>
<div class="dish-card">
    <c:if test="${requestScope.dish.image !=null}">
        <img src="res/${requestScope.dish.image}" alt="Dish Name">
    </c:if>
    <div class="dish-info">
        <form action="EditDish" method="post">
            <input type="hidden" name="dishID" value="${requestScope.dish.dishID}">
            <h3>
                <label>
                    <input type="text" name="name" value="${requestScope.dish.name}">
                </label>
            </h3>
            <p>定价:
                <label>
                    <input type="number" name="price" value="${requestScope.dish.price}">
                </label>
                元/份</p>
            <p>促销价:
                <label>
                    <input type="number" name="promptprice" value="${requestScope.dish.promotionPrice}">
                </label>
            </p>
            <p>菜系:
                <label>
                    <input type="text" name="type" value="${requestScope.dish.type}">
                </label>
            </p>
            <input type="submit" class="button" value="提交修改">
        </form>
    </div>
</div>
</body>
</html>
