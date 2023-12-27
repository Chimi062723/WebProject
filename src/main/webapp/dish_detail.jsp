<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>菜品详情</title>
    <link rel="stylesheet" href="css/dishdetail.css"/>
    <link rel="stylesheet" href="css/add_pic.css"/>
    <style>
        .show{
           display: none;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/uploadfile.js" defer></script>
</head>
<body>
<jsp:include page="backToTopComponent.jsp" />
<div class="container">
    <a href="GetPostServlet" class="back-button">返回</a>
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
                <input type="hidden" name="picture" id="url">
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
                <input type="submit">
            </form>
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
        </div>
    </div>
</div>
</body>
</html>

