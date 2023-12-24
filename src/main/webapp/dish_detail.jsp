<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/24
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜品详情</title>
    <link rel="stylesheet" href="css/dishdetail.css"/> <!-- 链接到外部CSS文件 -->

</head>
<body>
<div class="container">
    <a href="javascript:history.back()" class="back-button">返回</a>
    <div class="dish-detail" style="flex:2; flex-grow: 1">
        <img src="res/${requestScope.dish.image}" alt="${requestScope.dish.name}" class="dish-image"/>
        <div class="dish-info">
            <h1>${requestScope.dish.name}</h1>
            <p><strong>价格:</strong> ${requestScope.dish.price}</p>
            <c:if test="${requestScope.dish.promotionPrice!= 0}">
                <p><strong>促销价:</strong> ${requestScope.dish.promotionPrice}</p>
            </c:if>
            <p><strong>类别:</strong> ${requestScope.dish.type}</p>
            <p><strong>开设餐厅:</strong> ${requestScope.dish.canteen.name}</p>
            <c:forEach var="review" items="${requestScope.reviews}">
                <div class="review">
                    <p><strong>发表人:</strong> ${review.sender.userName}</p>
                    <p><strong>评分:</strong> ${review.rating}</p>
                    <p><strong>评论:</strong> ${review.comment}</p>
                    <p><strong>发表时间:</strong> ${review.createDate}</p>
                    <c:if test="${review.picture!= null}">
                        <img src="res/${review.picture}" alt="图片" class="review-image"/>
                    </c:if>
                    <c:if test="${review.reply!= null}">
                        <p><strong>食堂管理员回复:</strong> ${review.reply}</p>
                    </c:if>
                </div>
            </c:forEach>
            <!-- 其他信息 -->
        </div>
        <div class="review" style="flex:1">
            <h1>发表新的评论：</h1>
            <form action="addReview" method="post">
                <input type="hidden" name="dishID" value="${requestScope.dish.dishID}">
                <label>
                    评分:
                    <input type="radio" name="rating" value="1">
                    <input type="radio" name="rating" value="2">
                    <input type="radio" name="rating" value="3">
                    <input type="radio" name="rating" value="4">
                    <input type="radio" name="rating" value="5">
                </label>
                <br>
                <label>
                    评论:
                    <input type="text" name="comment">
                </label>
                <br>
                <br>
                <label for="picture">
                    <button>选择需要上传的图片</button>
                </label>
                <input style="opacity: 0" id="picture" type="file" accept="image/*" name="picture">

                <input type="submit">
                <img src="" alt="你上传的图片将会在这显示" style="display: none">
            </form>
        </div>
    </div>
</div>
</body>
<script>
    // 原理是把本地图片路径："D(盘符):/image/..."转为"http://..."格式路径来进行显示图片
    $("#picture").change(function() {
        let $file = $(this);
        let objUrl = $file[0].files[0];
        //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome
        let windowURL = window.URL || window.webkitURL;
        //createObjectURL创建一个指向该参数对象(图片)的URL
        let dataURL;
        dataURL = windowURL.createObjectURL(objUrl);
        //把url给图片的src，让其显示
        $("#imageview").attr("src",dataURL);
        $('#imageview').attr("style","display:inline");
    });

</script>
</html>
