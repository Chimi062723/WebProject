<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>USST食堂管理系统</title>
    <link rel="stylesheet" href="css/customer_menu.css"/> <!-- 链接到外部CSS文件 -->
    <!-- 内联样式或外部样式表应包括页面布局、字体、颜色等的定义 -->
</head>
<body>
<jsp:include page="custom_sidebar.jspf"/>
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
            <span class="post-details">帖子内容${sessionScope.post2.content}</span>
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
            <span class="post-details">帖子内容:${sessionScope.post2.content}</span>
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
            <span class="post-details">帖子内容${sessionScope.post2.content}</span>
            <br>
            <img src="res/${sessionScope.post3.picture}" alt="${sessionScope.post3.title}"/>
            <br>
            <span class="post-actions">
                <a href="#">点赞</a>
                <!-- 更多操作 -->
            </span>
        </div>
    </div>

    <!-- 公告区 -->
    <div class="announcement-section">
        <p>促销活动</p>
        <!-- 动态生成公告内容，示例代码 -->
        <div class="announcement">
            <textarea rows="4" readonly>这里是公告1内容</textarea>
        </div>
        <div class="announcement">
            <textarea rows="4" readonly>这里是公告2内容</textarea>
        </div>
        <div class="announcement">
            <textarea rows="4" readonly>这里是公告3内容</textarea>
        </div>
        <div class="announcement">
            <textarea rows="4" readonly>这里是公告4内容</textarea>
        </div>
        <!-- 更多公告 -->
    </div>
    <div>
        <p>最新投票</p>
        <div class="vote-section">
            <div class="vote-item">
                <img src="placeholder-image.jpg" alt="${vote1.title}"/>
                <span class="vote-title">${vote1.title}</span>
                <span class="vote-time">${vote1.createTime}</span>
                <span class="vote-details">${vote1.content}</span>
                <span class="vote-actions">
                    <a href="#">参与投票</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="vote-item">
                <img src="placeholder-image.jpg" alt="${vote2.title}"/>
                <span class="vote-title">${vote2.title}</span>
                <span class="vote-time">${vote2.createTime}</span>
                <span class="vote-details">${vote2.content}</span>
                <span class="vote-actions">
                    <a href="#">参与投票</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="vote-item">
                <img src="placeholder-image.jpg" alt="${vote3.title}"/>
                <span class="vote-title">${vote3.title}</span>
                <span class="vote-time">${vote3.createTime}</span>
                <span class="vote-details">${vote3.content}</span>
                <span class="vote-actions">
                    <a href="#">参与投票</a>
                    <!-- 更多操作 -->
                </span>
            </div>
        </div>
    </div>
    <div>
        <p>最新评论</p>
        <div class="review-section">
            <div class="review-item">
                <img src="placeholder-image.jpg" alt="${comment1.title}"/>
                <span class="review-name">${comment1.name}</span>
                <span class="review-time">${comment1.createTime}</span>
                <span class="review-details">${comment1.content}</span>
                <span class="review-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="review-item">
                <img src="placeholder-image.jpg" alt="${comment2.title}"/>
                <span class="review-name">${comment2.name}</span>
                <span class="review-time">${comment2.createTime}</span>
                <span class="review-details">${comment2.content}</span>
                <span class="review-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="review-item">
                <img src="placeholder-image.jpg" alt="${comment3.title}"/>
                <span class="review-name">${comment3.name}</span>
                <span class="review-time">${comment3.createTime}</span>
                <span class="review-details">${comment3.content}</span>
                <span class="review-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
        </div>
    </div>
    <div>
        <p>投诉处理</p>
        <div class="complaint-section">
            <div class="complaint-item">
                <img src="placeholder-image.jpg" alt="${complaint1.title}"/>
                <span class="complaint-name">${complaint1.name}</span>
                <span class="complaint-time">${complaint1.createTime}</span>
                <span class="complaint-details">${complaint1.content}</span>
                <span class="complaint-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="complaint-item">
                <img src="placeholder-image.jpg" alt="${complaint2.title}"/>
                <span class="complaint-name">${complaint2.name}</span>
                <span class="complaint-time">${complaint2.createTime}</span>
                <span class="complaint-details">${complaint2.content}</span>
                <span class="complaint-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="complaint-item">
                <img src="placeholder-image.jpg" alt="${complaint3.title}"/>
                <span class="complaint-name">${complaint3.name}</span>
                <span class="complaint-time">${complaint3.createTime}</span>
                <span class="complaint-details">${complaint3.content}</span>
                <span class="complaint-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
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
    let setCardSize = () => { cardSize = cards[0].clientWidth; };

    let moveToStart = () => { track.style.transform = 'translateX(-' + cardSize + 'px)'; };
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
