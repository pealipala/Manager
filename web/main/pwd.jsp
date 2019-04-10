<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/22
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="../js/jquery.js"></script>

    <script type="text/javascript">
        //校验密码修改
        $(function () {
            $("#fm").submit(function () {
                if($("#newPwd").val()==""){//校验新密码
                    alert("新密码不能为空");
                    return false;
                }else if($("#cfPwd").val()==""){
                    alert("确认密码不能为空");//校验确认密码
                    return false;
                }else if($("#newPwd").val()!=$("#cfPwd").val()){
                    alert("两次密码输入不一致请重新输入");
                    return false;
                }else{
                    return true;
                }

            })

        })
    </script>

</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码信息</span></div>
    <form action="/user" method="post" id="fm" target="_top">

        <input  type="hidden" name="oper" value="pwd" />
        <ul class="forminfo">
            <li><label>新密码</label><input name="newPwd" id="newPwd" type="password" class="dfinput" /><i></i></li>
            <li><label>确认密码</label><input name="" id="cfPwd" type="password" class="dfinput" /><i></i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="loginbtn" value="确认保存"/></li>
        </ul>
    </form>

</div>


</body>

</html>

