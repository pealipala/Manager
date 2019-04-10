<%@ page import="com.pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/21
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
            //退出功能
            $("#out").click(function () {
                var flag=window.confirm("你真的要退出吗?");
                if(flag){
                    window.top.location.href="/user?oper=out";
                }
            })
        })
    </script>


</head>

<body style="background:url(../images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.html" target="_parent"><img src="../images/logo.png" title="系统首页" /></a>
</div>


<div class="topright">
    <ul>
        <li><a href="javascript:void(0)"  id="out">退出</a></li>
    </ul>

    <div class="user">
        <span>
            <c:choose >
                <c:when test="${sessionScope.user.uname!=null}">
                    <c:out value="${sessionScope.user.uname}"></c:out>
                </c:when>
                <c:when test="${sessionScope.user.uname==null}">
                    <script type="text/javascript">window.top.location.href="/user?oper=relogin";</script>
                </c:when>
            </c:choose>
        </span>
        <span>当前在线人数:${applicationScope.count}</span>
        <span>网页浏览次数:${applicationScope.nums}</span>
    </div>


</div>

</body>
</html>

