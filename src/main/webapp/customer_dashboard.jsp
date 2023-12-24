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
                            <a href="DishDetailServlet?id=${sessionScope.dish1.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish2.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish3.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish4.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish5.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish6.dishID}">详情</a>
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
                            <a href="DishDetailServlet?id=${sessionScope.dish1.dishID}">详情</a>
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
                <c:forEach items="${sessionScope.posts}" var="post">
                    <div class="post">
                        <span class="post-author">发表人：${post.author.userName}</span>
                        <br>
                        <span class="post-title">标题：${post.title}</span>
                        <br>
                        <span class="post-time">发表时间：${post.createDate}</span>
                        <br>
                        <span class="post-details">帖子内容：${post.content}</span>
                        <br>
                        <img src="res/${post.picture}" alt="${post.title}"/>
                        <br>
                        <span class="comment-list">
                            <c:forEach items="${post.comments}" var="comment" varStatus="status">
                                <span class="comment-item">
                                    <span class="comment-count">回复：${status.count}</span>
                                    <span class="comment-author">发表人：${comment.author.userName}</span>
                                    <span class="comment-content">评论内容：${comment.content}</span>
                                    <span class="comment-time">回复时间：${comment.createDate}</span>
                                    <br>
                                </span>
                            </c:forEach>
                        </span>
                        <br>
                        <div class="post-actions">
                            <form class="comment-form" action="AddPostComment" method="post">
                                <label>
                                    <input type="text" name="commentContent" placeholder="输入评论内容" class="comment-input"/>
                                </label>
                                <input type="hidden" name="postID" value="${post.postID}"/>
                                <a href="#" class="like-link" data-liked="false">点赞</a>
                                <button type="submit" class="comment-submit">评论</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- 投诉区 -->
            <div class="complaint-section">
                <p>我要投诉</p>
                <div class="complaint-item">
                    <form action="ComplaintServlet" method="post">
                        <div>
                        <select id="canteenID" name="canteenID">
                            <option value="0">请选择食堂</option>
                            <c:forEach items="${sessionScope.canteens}" var="canteen">
                                <option value="${canteen.canteenID}">${canteen.name}</option>
                            </c:forEach>
                        </select>
                        <input type="text" name="content" placeholder="请填写投诉内容">
                        </div>
                        <div>
                            <input type="submit" value="投诉">
                            <a href="ComplaintServlet" class="my-complaints-btn">我的投诉</a>
                        </div>
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
                            <span class="review-reply">食堂管理员回复：${lastReview.reply}</span>
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
    //以下是点赞逻辑
    document.querySelectorAll('.like-link').forEach(item => {
        item.addEventListener('click', function (e) {
            e.preventDefault();
            let isLiked = this.getAttribute('data-liked') === 'true';
            if (isLiked) {
                // 如果已经是“已点赞”状态，切换到“点赞”
                this.textContent = '点赞';
                this.classList.remove('liked');
            } else {
                // 如果是“点赞”状态，切换到“已点赞”
                this.textContent = '已点赞';
                this.classList.add('liked');
            }
            this.setAttribute('data-liked', !isLiked);
        });
    });

    //处理评论不能为空逻辑
    document.addEventListener('DOMContentLoaded', function() {
        document.querySelectorAll('.comment-form').forEach(function(form) {
            form.addEventListener('submit', function(event) {
                var commentInput = this.querySelector('.comment-input');
                if (!commentInput.value.trim()) {
                    event.preventDefault(); // 阻止表单提交
                    alert('评论不能为空');
                }
            });
        });
    });


    //强制页面返回时更新一次，否则无法动态加载修改后的数据
    window.addEventListener("pageshow", function (event) {
        if (event.persisted || (window.performance && window.performance.navigation.type == 2)) {
            // 页面是从历史记录中加载的
            window.location.reload(true);
        }
    });


</script>
</body>
</html>
