<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax测试</title>
</head>
<script type="text/javascript">
    function getData() {
        //创建ajax引擎对象
        var ajax;
        if (window.XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }else if(window.ActiveXObject) {
            ajax=new ActiveXObject("Msxml2.XMLHTTP");
        }
        //覆写onreadystatement函数
        ajax.onreadystatechange=function () {
            //判断ajax状态码
            if(ajax.readyState==4){
                if(ajax.status==200){
                    //获取响应内容
                    var result=ajax.responseText;
                    //处理响应内容
                    //获取元素对象
                    var showdiv=document.getElementById("showdiv");
                    showdiv.innerHTML=result;
                }else if(ajax.status==404){
                    var showdiv=document.getElementById("showdiv");
                    showdiv.innerHTML="请求的资源不存在";
                }else if(ajax.status==500){
                    var showdiv=document.getElementById("showdiv");
                    showdiv.innerHTML="服务器繁忙";
                }
            }else {
                var showdiv=document.getElementById("showdiv");
                showdiv.innerHTML="<img  src='../images/timg.gif' height='100' width='200'>";
            }
        }
        ajax.open("get","/ajax");
        ajax.send();
    }
    
</script>
<style type="text/css">
    #showdiv{
        border: solid 2px;
        height: 100px;
        width: 200px;
    }
</style>
<body>
<h3>ajax测试</h3>
<hr>
<input type="button" value="测试" onclick="getData()"/>
<div id="showdiv">

</div>

</body>
</html>
