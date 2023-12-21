<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>USST食堂管理系统</title>
    <link rel="stylesheet" href="css/customer_menu.css" /> <!-- 链接到外部CSS文件 -->
    <!-- 内联样式或外部样式表应包括页面布局、字体、颜色等的定义 -->
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="customer_dashboard.jsp">首页</a>
    <a href="customer_dish.jsp">菜品一览</a>
    <a href="customer_community.jsp">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
    <div class="bottom" id="logoutbt">
        <form id="logout" action="logout" method="post">
            <input type="submit"   class="button"value="退出" />
        </form>
    </div>
</div>

<div id="main-content">
    <!-- 菜品展示区 -->
    <div class="dish-display">
        <p>>菜品上新</p>
        <!-- 动态生成菜品卡片，示例代码 -->
        <div class="dish-card">
            <img src="placeholder-image.jpg" alt="${dish1.name}" />
            <div class="dish-details">
                <span class="dish-name">${dish1.name}</span>
                <span class="dish-price">价格: ${dish1.price}</span>
                <span class="dish-type">类别: ${dish1.cuisineType}</span>
                <a href="dish_detial_Servlet?name='${dish1.name}'">详情</a>
                <!-- 更多信息 -->
            </div>
        </div>
        <div class="dish-card">
            <img src="placeholder-image.jpg" alt="${dish2.name}" />
            <div class="dish-details">
                <span class="dish-name">${dish2.name}</span>
                <span class="dish-price">价格: ${dish2.price}</span>
                <span class="dish-type">类别: ${dish2.cuisineType}</span>
                <a href="dish_detial_Servlet?name='${dish2.name}'">详情</a>
                <!-- 更多信息 -->
            </div>
        </div>
        <div class="dish-card">
            <img src="placeholder-image.jpg" alt="${dish3.name}" />
            <div class="dish-details">
                <span class="dish-name">${dish3.name}</span>
                <span class="dish-price">价格: ${dish3.price}</span>
                <span class="dish-type">类别: ${dish3.cuisineType}</span>
                <a href="dish_detial_Servlet?name='${dish3.name}'">详情</a>
                <!-- 更多信息 -->
            </div>
        </div>
        <!-- 更多菜品卡片 -->
    </div>

    <!-- 交流区 -->
    <div class="communication-section">
        <p>社区热点</p>
        <!-- 动态生成交流内容，示例代码 -->
        <div class="post">
            <img src="placeholder-image.jpg" alt="${post1.title}" />
            <span class="post-time">${post1.createTime}</span>
            <span class="post-details">${post2.centent}</span>
            <span class="post-actions">
                <a href="#">点赞</a>
                <!-- 更多操作 -->
            </span>
        </div>
        <div class="post">
            <img src="placeholder-image.jpg" alt="${post2.title}" />
            <span class="post-time">${post2.createTime}</span>
            <span class="post-details">${post2.content}</span>
            <span class="post-actions">
                <a href="#">点赞</a>
                <!-- 更多操作 -->
            </span>
        </div>
        <div class="post">
            <img src="placeholder-image.jpg" alt="${post3.title}" />
            <span class="post-time">${post3.createTime}</span>
            <span class="post-details">${post3.content}</span>
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
                <img src="placeholder-image.jpg" alt="${vote1.title}" />
                <span class="vote-title">${vote1.title}</span>
                <span class="vote-time">${vote1.createTime}</span>
                <span class="vote-details">${vote1.content}</span>
                <span class="vote-actions">
                    <a href="#">参与投票</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="vote-item">
                <img src="placeholder-image.jpg" alt="${vote2.title}" />
                <span class="vote-title">${vote2.title}</span>
                <span class="vote-time">${vote2.createTime}</span>
                <span class="vote-details">${vote2.content}</span>
                <span class="vote-actions">
                    <a href="#">参与投票</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="vote-item">
                <img src="placeholder-image.jpg" alt="${vote3.title}" />
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
                <img src="placeholder-image.jpg" alt="${comment1.title}" />
                <span class="review-name">${comment1.name}</span>
                <span class="review-time">${comment1.createTime}</span>
                <span class="review-details">${comment1.content}</span>
                <span class="review-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="review-item">
                <img src="placeholder-image.jpg" alt="${comment2.title}" />
                <span class="review-name">${comment2.name}</span>
                <span class="review-time">${comment2.createTime}</span>
                <span class="review-details">${comment2.content}</span>
                <span class="review-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="review-item">
                <img src="placeholder-image.jpg" alt="${comment3.title}" />
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
                <img src="placeholder-image.jpg" alt="${complaint1.title}" />
                <span class="complaint-name">${complaint1.name}</span>
                <span class="complaint-time">${complaint1.createTime}</span>
                <span class="complaint-details">${complaint1.content}</span>
                <span class="complaint-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="complaint-item">
                <img src="placeholder-image.jpg" alt="${complaint2.title}" />
                <span class="complaint-name">${complaint2.name}</span>
                <span class="complaint-time">${complaint2.createTime}</span>
                <span class="complaint-details">${complaint2.content}</span>
                <span class="complaint-actions">
                    <a href="#">回复</a>
                    <!-- 更多操作 -->
                </span>
            </div>
            <div class="complaint-item">
                <img src="placeholder-image.jpg" alt="${complaint3.title}" />
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
    // 在这里添加JavaScript代码
</script>
</body>
</html>
