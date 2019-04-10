<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/21
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <br />
    <c:choose>
        <c:when test="${flag==0}">
            <div style="text-align: center;">
                <span style="font-size: 15px;color:darkred;font-weight: bold;">用户名或者密码错误</span>
            </div>
        </c:when>
        <c:when test="${flag==1}">
            <div style="text-align: center;">
                <span style="font-size: 15px;color:darkred;font-weight: bold;">密码修改成功</span>
            </div>
        </c:when>
        <c:when test="${flag==2}">
            <div style="text-align: center;">
                <span style="font-size: 15px;color:darkred;font-weight: bold;">用户注册成功</span>
            </div>
        </c:when>
        <c:when test="${flag==3}">
            <div style="text-align: center;">
                <span style="font-size: 15px;color:darkred;font-weight: bold;">用户登录失效，请重新登录</span>
            </div>
        </c:when>
    </c:choose>
    <c:remove var="flag"></c:remove>

    <div class="loginbox loginbox1">
        <form action="user" method="post">
            <input type="hidden" name="oper" value="login" />
            <ul>
                <li></li>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser"  /></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd"  /></li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><a href="main/reg.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>

    </div>

</div>


<div class="loginbm">交流QQ:1029102110</div>


</body>

</html>
