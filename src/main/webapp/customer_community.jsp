<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<jsp:include page="custom_sidebar.jsp"/>
<div class="container">
    <h1 class="text-center mt-4 mb-4">社区论坛</h1>

    <form action="PostMessageServlet" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="title" class="form-label">标题:</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">内容:</label>
            <textarea class="form-control" id="content" name="content" rows="4" required></textarea>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">上传图片:</label>
            <input type="file" class="form-control" id="image" name="image">
        </div>
        <button type="submit" class="btn btn-primary">发表</button>
    </form>

    <form action="SearchForumServlet" method="get" class="mt-4">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="searchQuery" placeholder="搜索标题或用户名">
            <button class="btn btn-outline-secondary" type="submit">搜索</button>
        </div>
    </form>

    <div class="mb-3">
        <button onclick="sort('time')" class="btn btn-secondary me-2">按时间排序</button>
        <button onclick="sort('popularity')" class="btn btn-secondary">按热度排序</button>
    </div>

    <div class="message-list">
        <c:forEach items="${requestScope.postList}" var="post">
            <c:if test="${post.commentID==-1}">
                <div class="post">
                    <span class="post-author">发表人：${post.author.userName}</span>
                    <br>
                    <span class="post-title">标题：${post.title}</span>
                    <br>
                    <span class="post-time">发表时间：${post.createDate}</span>
                    <br>
                    <span class="post-details">帖子内容：${post.content}</span>
                    <br>
                    <c:if test="${post.picture!=null}">
                        <img src="res/${post.picture}" alt="${post.title}"/>
                        <br>
                    </c:if>
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
                        <form class="comment-form" action="AddPostComment" method="get">
                            <label>
                                <input type="text" name="commentContent" placeholder="输入评论内容"
                                       class="comment-input"/>
                            </label>
                            <input type="hidden" name="postID" value="${post.postID}"/>
                            <a href="#" class="like-link" data-liked="false">点赞</a>
                            <button type="submit" class="comment-submit">评论</button>
                        </form>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>

<script>
    function sort(type) {
        // 根据排序类型调整消息显示顺序
    }

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
    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('.comment-form').forEach(function (form) {
            form.addEventListener('submit', function (event) {
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
</div>
</body>
</html>
