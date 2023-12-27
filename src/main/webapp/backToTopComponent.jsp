<!-- 回到顶部按钮的 HTML 结构 -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="return-top" class="top_e">
    <img src="res/toTop.png" width="60" id="img" >
    <div style="width:60px;margin:auto;">
        <p id='font' style="font-size:15px; text-align: center;margin-left:1px;">TOP</p>
    </div>
</div>


<style>

    .top_e{
        position:fixed;right:10px;bottom:20px;
        background: rgba(47, 23, 135, 0);
        border-radius:15px;
        cursor:pointer;
        /*display:none;*/
        width:60px;
        height:60px;
    }
    .top_e:hover
    {
        color: #2f1787;
        background:rgba(204,200,255,0.6);
    }
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    // 控制按钮的显示和消失
    $(window).scroll(function() {
        if ($(window).scrollTop() > 300) {
            $('#return-top').fadeIn(300);
        } else {
            $('#return-top').fadeOut(200);
        }
    });

    // 点击按钮，使得页面返回顶部
    $("#return-top").click(function() {
        window.scrollTo({
            top: 0,
            behavior: "smooth" // 实现平滑滚动到顶部
        });
    });

    // 鼠标悬浮按钮之上，图片消失，文字显示
    $(".top_e").mouseover(function() {
        // $("#img").hide();
        $("#font").show();
    });

    // 鼠标离开，文字消失，图片显示。
    $(".top_e").mouseout(function() {
        $("#font").hide();
        $("#img").show();
    });


</script>
