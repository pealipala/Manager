<%@ page import="com.sun.org.apache.regexp.internal.RE" %><%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/23
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Basic ValidateBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../css/demo.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
<div   tyle="margin:20px 0;"></div>
<div   class="easyui-panel" title="用户注册" style="width:400px;padding:10px 60px 20px 60px">
    <form action="/user" method="post">
        <input type="hidden" name="oper" value="reg">
    <table cellpadding="5">
        <tr>
            <td>用户名:</td>
            <td><input name="uname" class="easyui-validatebox textbox" data-options="required:true" missingMessage="用户名必填" ></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input name="pwd" class="easyui-validatebox textbox" data-options="required:true" missingMessage="密码必填"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                男:<input type="radio" name="sex" value="1" checked="checked"/>
                女:<input type="radio" name="sex" value="0"/>
            </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input name="age" class="easyui-validatebox textbox" data-options="required:true" missingMessage="年龄必填"></td>
        </tr>
        <tr>
            <td>出生日期:</td>
            <td><input name="birth" class="easyui-datebox textbox" data-options="required:true" missingMessage="出生日期必填"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="reg" value="注册"/>
            </td>
        </tr>
    </table>
    </form>
</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>

</body>
</html>