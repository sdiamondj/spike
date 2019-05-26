<%--
  Created by IntelliJ IDEA.
  User: 95493
  Date: 2019/4/15
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" media="screen" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/reset.css"/>
</head>
<body>

<div id="particles-js">
    <form method="post" action="/user/register">
        <div class="login">
            <div class="login-top">
                注册
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="/images/name.png"/></div>
                <div class="login-center-input">
                    <input type="text" name="username" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                    <div class="login-center-input-text">用户名</div>
                </div>
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="/images/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" name="password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                    <div class="login-center-input-text">密码</div>
                </div>
            </div>
            <a href="/s/index" style="position: relative;left: 130px;top:-60px;color: greenyellow;">返回登录</a>
            <input type="submit" value="注册" class="login-button">
        </div>
        <div class="sk-rotating-plane"></div>
    </form>
</div>

<!-- scripts -->
<script src="/js/particles.min.js"></script>
<script src="/js/app.js"></script>

</body>
</html>
