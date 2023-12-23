<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/24
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜品详情</title>
    <link rel="stylesheet" href="css/dishdetail.css"/> <!-- 链接到外部CSS文件 -->
</head>
<body>
<div class="container">
    <a href="javascript:history.back()" class="back-button">返回</a>
    <div class="dish-detail">
        <img src="res/${requestScope.dish.image}" alt="${requestScope.dish.name}" class="dish-image"/>
        <div class="dish-info">
            <h1>${requestScope.dish.name}</h1>
            <p><strong>价格:</strong> ${requestScope.dish.price}</p>
            <c:if test="${requestScope.dish.promotionPrice!= null}">
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
                        <p><strong>回复:</strong> ${review.reply}</p>
                    </c:if>
                </div>
            </c:forEach>
            <!-- 其他信息 -->
        </div>
    </div>
</div>
</body>
</html>
