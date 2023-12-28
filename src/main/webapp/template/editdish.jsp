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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add_dish.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/uploadfile.js" defer></script>
    <style>
        .show{
            display: none;
        }
    </style>
</head>
<body>
<div class="dish-card">
    <c:if test="${requestScope.dish.image !=null}">
        <img src="res/${requestScope.dish.image}" alt="Dish Name" style="width: 200px">
    </c:if>
    <div class="dish-info">
        <form action="upFile" method="post" enctype="multipart/form-data" target="if">
            <label for="picture">
                选择需要上传的图片
            </label>
            <input id="picture" type="file" accept="image/*" name="picture">
            <button id="submit" onclick="picsubmit()">提交图片</button>
        </form>
        <iframe name="if" style="display: none">
        </iframe>
        <img class="show" id="imageview" src="" alt="图片将会在这里显示" style="width:300px"/>
        <form action="EditDish" method="post">
            <input type="hidden" name="picture" id="url" value="${requestScope.dish.image}">
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
