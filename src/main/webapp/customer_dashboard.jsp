<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>USST食堂管理系统</title>
    <link rel="stylesheet" href="css/customer_menu.css"/> <!-- 链接到外部CSS文件 -->
    <!-- 内联样式或外部样式表应包括页面布局、字体、颜色等的定义 -->
</head>
<body>
<jsp:include page="custom_sidebar.jsp"/>
<div id="main-content">
    <!-- 菜品展示区 -->
    <div class="dish-display">
        <p>菜品上新</p>
        <div class="dish-carousel">
            <button class="carousel-control prev">←</button>
            <div class="carousel-track-container">
                <div class="carousel-track">
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish6.image}" alt="${sessionScope.dish6.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish6.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish6.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish6.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.dish6.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish1.image}" alt="${sessionScope.dish1.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish1.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish1.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish1.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?id='${sessionScope.dish1.dishID}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish2.image}" alt="${sessionScope.dish2.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish2.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish2.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish2.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.ish2.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish3.image}" alt="${sessionScope.dish3.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish3.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish3.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish3.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.dish3.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish4.image}" alt="${sessionScope.dish4.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish4.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish4.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish4.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.dish4.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish5.image}" alt="${sessionScope.dish5.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish5.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish5.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish5.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.dish5.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish6.image}" alt="${sessionScope.dish6.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish6.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish6.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish6.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?name='${sessionScope.dish6.name}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                    <div class="dish-card">
                        <img src="res/${sessionScope.dish1.image}" alt="${sessionScope.dish1.name}"/>
                        <div class="dish-details">
                            <span class="dish-name">${sessionScope.dish1.name}</span>
                            <br>
                            <span class="dish-price">价格: ${sessionScope.dish1.price}</span>
                            <br>
                            <span class="dish-type">类别: ${sessionScope.dish1.type}</span>
                            <br>
                            <a href="dish_detial_Servlet?id='${sessionScope.dish1.dishID}'">详情</a>
                            <!-- 更多信息 -->
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control next">→</button>
        </div>
    </div>
    <div class="content-row">
        <div class="content-column">
            <!-- 交流区 -->
            <div class="communication-section">
                <p>社区热点</p>
                <!-- 动态生成交流内容，示例代码 -->
                <div class="post">
                    <span class="post-author">发表人：${sessionScope.post1.author.userName}</span>
                    <br>
                    <span class="post-title">标题：${sessionScope.post1.title}</span>
                    <br>
                    <span class="post-time">发表时间：${sessionScope.post1.createDate}</span>
                    <br>
                    <span class="post-details">帖子内容：${sessionScope.post1.content}</span>
                    <br>
                    <img src="res/${sessionScope.post1.picture}" alt="${sessionScope.post1.title}"/>
                    <br>
                    <span class="post-actions">
                        <a href="#">点赞</a>
                        <!-- 更多操作 -->
                    </span>
                </div>
                <div class="post">
                    <span class="post-author">发表人：${sessionScope.post2.author.userName}</span>
                    <br>
                    <span class="post-title">标题：${sessionScope.post2.title}</span>
                    <br>
                    <span class="post-time">发表时间：${sessionScope.post2.createDate}</span>
                    <br>
                    <span class="post-details">帖子内容：${sessionScope.post2.content}</span>
                    <br>
                    <img src="res/${sessionScope.post2.picture}" alt="${sessionScope.post2.title}"/>
                    <br>
                    <span class="post-actions">
                        <a href="#">点赞</a>
                        <!-- 更多操作 -->
                    </span>
                </div>
                <div class="post">
                    <span class="post-author">发表人：${sessionScope.post3.author.userName}</span>
                    <br>
                    <span class="post-title">标题：${sessionScope.post3.title}</span>
                    <br>
                    <span class="post-time">发表时间：${sessionScope.post3.createDate}</span>
                    <br>
                    <span class="post-details">帖子内容：${sessionScope.post3.content}</span>
                    <br>
                    <img src="res/${sessionScope.post3.picture}" alt="${sessionScope.post3.title}"/>
                    <br>
                    <span class="post-actions">
                        <a href="#">点赞</a>
                        <!-- 更多操作 -->
                    </span>
                </div>
            </div>
            <!-- 投诉区 -->
            <div class="complaint-section">
                <p>我要投诉</p>
                <div class="complaint-item">
                    <form action="ComplaintServlet" method="post">
                        <select id="canteenID" name="canteenID">
                            <option value="0">请选择食堂</option>
                            <c:forEach items="${sessionScope.canteens}" var="canteen">
                                <option value="${canteen.canteenID}">${canteen.name}</option>
                            </c:forEach>
                        </select>
                        <input type="text" name="content" placeholder="请填写投诉内容">
                        <input type="submit" value="投诉">
                    </form>
                </div>
            </div>
        </div>
        <div class="content-column">
            <!-- 公告区 -->
            <div class="announcement-section">
                <p>促销活动</p>
                <!-- 动态生成公告内容，示例代码 -->
                <c:forEach items="${sessionScope.canteens}" var="canteen">
                    <div class="announcement">
                        <p class="announcement-title">${canteen.name}</p>
                        <p class="announcement-content">${canteen.notice}</p>
                    </div>
                </c:forEach>
            </div>
            <!-- 投票区 -->
            <div class="vote-section">
                <p>最新投票</p>
                <div class="vote-item">
                    <span class="vote-title">${sessionScope.vote.title}</span>
                    <span class="vote-question">${sessionScope.vote.question}</span>
                    <form action="VoteServlet" method="post">
                        <input type="radio" name="result" id="1" value="${sessionScope.dish1.name}">
                        <label for="1">${sessionScope.dish1.name}</label>
                        <input type="radio" name="result" id="2" value="${sessionScope.dish2.name}">
                        <label for="2">${sessionScope.dish2.name}</label>
                        <input type="radio" name="result" id="3" value="${sessionScope.dish3.name}">
                        <label for="3">${sessionScope.dish3.name}</label>
                        <input type="radio" name="result" id="4" value="${sessionScope.dish4.name}">
                        <label for="4">${sessionScope.dish4.name}</label>
                        <input type="submit" value="投票">
                    </form>
                </div>
            </div>
            <!-- 评论区 -->
            <div class="review-section">
                <p>最新评论</p>
                <c:forEach items="${sessionScope.lastThreeReviews}" var="lastReview">
                    <div class="review-item">
                        <c:if test="${lastReview.picture!= null}">
                            <img src="res/${lastReview.picture}" alt="评论图片"/>
                            <br>
                        </c:if>
                        <span class="review-sender">评价者：${lastReview.sender.userName}</span>
                        <br>
                        <span class="review-dish">评价菜品：${lastReview.dish.name}</span>
                        <br>
                        <span class="review-rating">评分：${lastReview.rating} 分</span>
                        <br>
                        <span class="review-time">评价时间：${lastReview.createDate}</span>
                        <br>
                        <span class="review-details">评价内容：${lastReview.comment}</span>
                        <br>
                        <c:if test="${lastReview.reply!= null}">
                            <span class="review-reply">回复：${lastReview.reply}</span>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script>
    let track = document.querySelector('.carousel-track');
    let cards = Array.from(track.children);
    let prevButton = document.querySelector('.carousel-control.prev');
    let nextButton = document.querySelector('.carousel-control.next');
    let cardSize = cards[0].clientWidth;
    let setCardSize = () => {
        cardSize = cards[0].clientWidth;
    };

    let moveToStart = () => {
        track.style.transform = 'translateX(-' + cardSize + 'px)';
    };
    window.addEventListener('resize', setCardSize);
    window.addEventListener('resize', moveToStart);
    moveToStart();

    let currentIndex = 1;
    let interval = 3000; // 3秒自动滑动
    let autoMove;

    let moveCarousel = (index, noTransition = false) => {
        if (noTransition) {
            track.style.transition = 'none';
        } else {
            track.style.transition = 'transform 0.5s ease';
        }
        track.style.transform = 'translateX(-' + (cardSize * index) + 'px)';
    };

    let resetAutoMove = () => {
        clearInterval(autoMove);
        autoMove = setInterval(nextSlide, interval);
    };

    let nextSlide = () => {
        if (currentIndex >= cards.length - 1) {
            currentIndex = 1; // 跳转到第一个
            moveCarousel(currentIndex, true);
        } else {
            currentIndex++;
        }
        moveCarousel(currentIndex);
    };

    let prevSlide = () => {
        if (currentIndex <= 0) {
            currentIndex = cards.length - 2; // 跳转到最后一个
            moveCarousel(currentIndex, true);
        } else {
            currentIndex--;
        }
        moveCarousel(currentIndex);
    };

    nextButton.addEventListener('click', () => {
        resetAutoMove();
        nextSlide();
    });

    prevButton.addEventListener('click', () => {
        resetAutoMove();
        prevSlide();
    });

    autoMove = setInterval(nextSlide, interval);

</script>
</body>
</html>
