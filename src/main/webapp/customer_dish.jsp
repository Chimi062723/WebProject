<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>菜品一览</title>
    <link rel="stylesheet" href="css/customer_menu.css" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" >

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="backToTopComponent.jsp" />
<jsp:include page="custom_sidebar.jsp" />
<div class="container mt-3">
    <h1 class="text-center mt-4 mb-4">菜品一览</h1>
    <ul class="tabs" data-tab>
        <li class="tab-title active"><a href="#home">总览</a></li>
        <li class="tab-title"><a href="#menu1">菜系</a></li>
        <li class="tab-title"><a href="#menu2">食堂</a></li>
        <li class="tab-title"><a href="#menu3">价格</a></li>
    </ul>
    <div class="tabs-content">
        <div class="content active" id="home">
        </div>
        <div class="content" id="menu1"> <!-- 菜系选择 -->
            <form id="cuisine-form" action="customers_dish" method="get">
                <label for="cuisine-select">选择菜系: </label>
                <select  class="form-select" id="cuisine-select" name="cuisine">
                    <option value="all">所有菜品</option>
                    <c:forEach items="${sessionScope.cuisinestype}" var="cuisine">
                        <option value="${cuisine}">${cuisine}</option>
                    </c:forEach>
                </select>
            </form>
        </div>
        <div class="content" id="menu2">
            <form action="customers_dish" id="canteen-form"  method="get">
                <label for="canteen-select">选择食堂: </label>
                <select class="form-select"   id="canteen-select" name="canteenName">
                    <option value="all">所有食堂</option>
                    <c:forEach items="${sessionScope.canteens}" var="canteen">
                        <option value="${canteen.name}">${canteen.name}</option>
                    </c:forEach>
                </select>
            </form>
        </div>
        <div class="content" id="menu3">
            <form action="customers_dish" id="order-form"  method="get">
                <input type="submit" name="ascending" value="升序">
                <input type="submit" name="descending" value="降序">
            </form>
        </div>
        <div class="search-results">
            <!-- 动态生成的检索结果将在这里显示 -->
            <input type="hidden" value="${requestScope.dishListSize}">
            <c:if test="${requestScope.dishListSize == '0'}">
                <p>没有找到任何结果，更改筛选条件再试一次？</p>
            </c:if>
            <c:forEach items="${requestScope.dishList}" var="dish">
                <div class="dish-card">
                    <div class="dish-details">
                        <span class="dish-name">${dish.name}</span>
                        <span class="dish-price">价格: ${dish.price}</span>
                        <span class="dish-type">类别: ${dish.type}</span>
                        <span class="dish-canteen">食堂id: ${dish.canteenID}</span>
                        <a href="DishDetailServlet?id=${dish.dishID}">详情</a>
                        <!-- 更多信息 -->
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- 检索结果 -->


</div>
<script>
    $(document).ready(function() {
        $(document).foundation();
    })
    document.querySelectorAll('.dropdown-content a').forEach(anchor => {
        anchor.addEventListener('click', (event) => {
            // 阻止默认行为
            event.preventDefault();

            // 获取所选标签的href属性值
            let targetTab = event.target.getAttribute('href').replace('#', '');

            // 隐藏所有内容
            document.querySelectorAll('.content').forEach(content => {
                content.classList.remove('active');
            });

            // 显示目标内容
            document.getElementById(targetTab).classList.add('active');
        });
    });
    // 确保DOM加载完毕后，执行相关操作
    window.addEventListener('DOMContentLoaded', () => {
        const cuisineSelect = document.getElementById('cuisine-select');
        cuisineSelect.value = localStorage.getItem('selectedCuisine') || 'all'; // 恢复用户之前的菜系选择
        const canteenSelect = document.getElementById('canteen-select');
        canteenSelect.value = localStorage.getItem('selectedCanteen') || 'all'; // 恢复用户之前的食堂选择
        const orderSelect = document.getElementById('order-select');
        orderSelect.value = localStorage.getItem('selectedOrder') || 'all'; // 恢复用户之前顺序堂选择

        // 监听下拉菜单的change事件，保存用户选择到本地存储
        cuisineSelect.addEventListener('change', () => {
            localStorage.setItem('selectedCuisine', cuisineSelect.value);
        });
    })
    $(document).ready(function() {
        $(document).foundation();

        // 监听菜系选择变化，选定即提交表单
        $('#cuisine-select').change(function() {
            $('#cuisine-form').submit();
        });

        // 监听食堂选择变化，选定即提交表单
        $('#canteen-select').change(function() {
            $('#canteen-form').submit();
        });
        $('#order-form').submit(function() {
            $('#order-form').submit();
        });
    });
</script>


</body>
</html>
