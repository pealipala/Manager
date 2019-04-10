<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/3/27
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="../js/ajaxUtils.js"></script>
<script type="text/javascript">

  /*  function getData() {
        //获取用户请求信息
        //var uname=document.getElementById("uname");
        //创建引擎对象
        alert("text");
        var ajax;
        if(window.XMLHttpRequest){
            ajax=new XMLHttpRequest();
        }else if(window.ActiveXObject){
            ajax=new ActiveXObject("Msxml2.XMLHTTP");
        }
        //覆写onreadystament函数
        ajax.onreadystatechange=function () {
            //判断ajax状态码
            if(ajax.readyState==4){
                //判断响应状态码
                if(ajax.status==200){
                    var result=ajax.responseText;
                    eval("var user="+result);
                    var ta=document.getElementById("ta");
                    ta.innerHTML="";
                    var tr=ta.insertRow(0);
                    var cell0=tr.insertCell(0);
                    cell0.innerHTML="用户ID";
                    var cell1=tr.insertCell(1);
                    cell1.innerHTML="用户名";
                    var cell2=tr.insertCell(2);
                    cell2.innerHTML="密码";
                    var cell3=tr.insertCell(3);
                    cell3.innerHTML="性别";
                    var cell4=tr.insertCell(4);
                    cell4.innerHTML="年龄";
                    var cell5=tr.insertCell(5);
                    cell5.innerHTML="出生日期";
                    //插入新的行
                    var tr=ta.insertRow(1);
                    var cell0=tr.insertCell(0);
                    cell0.innerHTML=user.id;
                    var cell1=tr.insertCell(1);
                    cell1.innerHTML=user.uname;
                    var cell2=tr.insertCell(2);
                    cell2.innerHTML=user.pwd;
                    var cell3=tr.insertCell(3);
                    cell3.innerHTML=user.sex;
                    var cell4=tr.insertCell(4);
                    cell4.innerHTML=user.age;
                    var cell5=tr.insertCell(5);
                    cell5.innerHTML=user.birth;
                }
            }
        }
        //发送请求
        ajax.open("post","/user?oper=search",true);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        ajax.send("uname="+uname.value);
    }*/

    function getData(){
        var name=document.getElementById("uname").value;
        var data="uname="+name;
        ajaxUtils("post","/user?oper=search",data,function(a){
            //获取响应数据
            var result=a.responseText;
            //处理响应数据
            eval("var user="+result);
            var ta=document.getElementById("ta");
            ta.innerHTML="";
            var tr=ta.insertRow(0);
            var cell0=tr.insertCell(0);
            cell0.innerHTML="用户ID";
            var cell1=tr.insertCell(1);
            cell1.innerHTML="用户名";
            var cell2=tr.insertCell(2);
            cell2.innerHTML="密码";
            var cell3=tr.insertCell(3);
            cell3.innerHTML="性别";
            var cell4=tr.insertCell(4);
            cell4.innerHTML="年龄";
            var cell5=tr.insertCell(5);
            cell5.innerHTML="出生日期";
            //插入新的行
            var tr=ta.insertRow(1);
            var cell0=tr.insertCell(0);
            cell0.innerHTML=user.id;
            var cell1=tr.insertCell(1);
            cell1.innerHTML=user.uname;
            var cell2=tr.insertCell(2);
            cell2.innerHTML=user.pwd;
            var cell3=tr.insertCell(3);
            cell3.innerHTML=user.sex;
            var cell4=tr.insertCell(4);
            cell4.innerHTML=user.age;
            var cell5=tr.insertCell(5);
            cell5.innerHTML=user.birth;
        });
    }
</script>
<body>
        <h3 align="center">搜索用户信息</h3>
        <hr>
            <div align="center">
                <input type="text" name="uname" id="uname" value=""/>
                <input  type="button" value="搜索" onclick="getData()"/>
            </div>
        <hr>
        <table align="center" border="1px" id="ta">
        </table>

</body>
</html>
