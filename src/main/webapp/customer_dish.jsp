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
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
</head>
<body>
<jsp:include page="custom_sidebar.jspf" />
<div id="main-content">
<%--    <h2>菜品一览</h2>--%>

<%--    <!-- 检索表单 -->--%>
<%--    <form action="SearchDishesServlet" method="get">--%>
<%--        <select name="searchType">--%>
<%--            <option value="cuisine">菜系</option>--%>
<%--            <option value="price">价格</option>--%>
<%--            <option value="canteen">食堂</option>--%>
<%--        </select>--%>
<%--        <input type="text" name="searchQuery" />--%>
<%--        <input type="submit" value="检索" />--%>
<%--    </form>--%>
    <h2>菜品一览</h2>
    <ul class="tabs" data-tab>
        <li class="tab-title active"><a href="#home">总览</a></li>
        <li class="tab-title"><a href="#menu1">菜系</a></li>
        <li class="tab-title"><a href="#menu2">食堂</a></li>
        <li class="tab-title"><a href="#menu3">价格</a></li>
    </ul>
    <div class="tabs-content">
        <div class="content active" id="home">
            <h3>总览</h3>
            <p>列表/表格显示所有菜品</p>
        </div>
        <div class="content" id="menu1">
            <h3>菜系</h3>
            <p>呈现不同菜系的选项，点击之后只显示该菜系的菜品</p>
        </div>
        <div class="content" id="menu2">
            <h3>食堂</h3>
            <p>呈现不同食堂的选项，点击之后只显示该食堂的菜品</p>
        </div>
        <div class="content" id="menu3">
            <h3>价格</h3>
            <p>提供降序和升序按钮，点击之后按顺序显示</p>
        </div>
    </div>
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
<script>
    $(document).ready(function() {
        $(document).foundation();
    })
</script>


</body>
</html>
