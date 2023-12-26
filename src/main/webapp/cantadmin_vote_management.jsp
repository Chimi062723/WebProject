<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
</head>
<body>
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content" class="clearfix">
    <h2>投票与收集</h2>
    <form action="SubmitVoteServlet" method="post">
        <p>请选择您喜欢的菜品:</p>
        <!-- Dynamically generate voting options here -->
        <label>
            <input type="radio" name="dish" value="dish1"> 菜品1
        </label><br>
        <label>
            <input type="radio" name="dish" value="dish2"> 菜品2
        </label><br>
        <!-- Add more options as needed -->
        <input type="submit" value="提交">
        <input type="submit" value="结果">
    </form>

    <!-- Optionally add a section for results or additional data collection here -->
</div>
</body>
</html>
