<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:41
  To change this template use File | Settings | File Templates.
    需要传入的变量：
    dishes: 所有菜品信息

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>菜品维护</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/dish.css">
    <style>
    </style>
</head>
<body>
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content" class="clearfix">
    <div class="content-header">
        <form>
            <label for="search">搜索栏:</label>
            <input id="search" name="search" type="text" placeholder="搜索菜品..." class="search-box">
        </form>
        <button class="button add-new"
                onclick="search()"
        >搜索菜品</button>
        <button class="button add-new"
                onclick="addNew()"
        >添加菜品</button>
    </div>
    <!-- Dynamic generation of dish cards -->
    <c:forEach var="dish" items="${requestScope.dishes}">
        <div class="dish-card">
            <c:if test="${dish.image !=null}">
                <img src="res/${dish.image}" alt="Dish Name">
            </c:if>
            <div class="dish-info">
                <h3>${dish.name}</h3>
                <p>定价: ${dish.price}元/份</p>
                <p>促销价:
                    <c:if test="${dish.promotionPrice!=null||dish.promotionPrice!=0}">${dish.promotionPrice} 元/份</c:if>
                    <c:if test="${dish.promotionPrice==null||dish.promotionPrice==0}">暂时没有促销价</c:if>
                </p>
                <p>菜系: ${dish.type}</p>
                <button class="button" onclick="window.location.href='DeleteDish?id=${dish.dishID}'">删除</button>
                <button class="button" onclick="window.location.href='EditDish?id=${dish.dishID}'">修改</button>
            </div>
        </div>
    </c:forEach>
    <!-- Repeat for other dishes -->
</div>
</body>
<script>
    function search(){
        const index = document.getElementById("search").value;
        window.location.href="SearchDish?text="+index;
    }
    function addNew(){
        window.location.href="AddDish";
    }
</script>
</html>

