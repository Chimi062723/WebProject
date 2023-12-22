<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css" />
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="customer_dashboard.jsp">首页</a>
    <a href="customer_dish.jsp">菜品一览</a>
    <a href="customer_community.jsp">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
</div>
<div id="main-content">
    <h2>菜品一览</h2>

    <!-- 检索表单 -->
    <form action="SearchDishesServlet" method="get">
        <select name="searchType">
            <option value="cuisine">菜系</option>
            <option value="price">价格</option>
            <option value="canteen">食堂</option>
        </select>
        <input type="text" name="searchQuery" />
        <input type="submit" value="检索" />
    </form>

    <!-- 检索结果 -->
    <div id="search-results">
        <!-- 动态生成的检索结果将在这里显示 -->
        <c:forEach items="${dishes}" var="dish">
            <div class="dish-card">
                <img src="placeholder-image.jpg" alt="${dish.name}" />
                <div class="dish-details">
                    <span class="dish-name">${dish.name}</span>
                    <span class="dish-price">价格: ${dish.price}</span>
                    <span class="dish-type">类别: ${dish.cuisineType}</span>
                    <span class="dish-canteen">食堂: ${dish.canteen}</span>
                    <a href="dish_detial_Servlet?name='${dish.name}'">详情</a>
                    <!-- 更多信息 -->
                </div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
