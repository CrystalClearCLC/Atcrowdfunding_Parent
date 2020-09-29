<%--
  Created by IntelliJ IDEA.
  User: 10855
  Date: 2020/4/1
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/login.css">
    <style>

    </style>
</head>
<body>
${exception.message}
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form id="doLogin" action="${APP_PATH}/doLogin.do" METHOD="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="floginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="fuserpswd" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control"  id="ftype" name="type" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script>
   /*  $(function(){
         alert($("#ftype").val());
       });*/
    function dologin() {
        //document.getElementById("doLogin").submit();
      /* ${"#doLogin"}.submit();*/


        var floginacct=$("#floginacct");
        if($.trim(floginacct.val())==""){ //去掉前后两端空格
            alert("登录用户名称不允许为空!");
            floginacct.focus();
            return ;
        }

        var fuserpswd=$("#fuserpswd");
        if($.trim(fuserpswd.val())==""){
            alert("登录用户密码不允许为空!");
            fuserpswd.focus();
            return ;
        }

        var ftype=$("#ftype");

        $.ajax({
            type: "POST",
            data:{
                loginacct:floginacct.val(),
                userpswd:fuserpswd.val(),
                type:ftype.val()
            },
            url:"${APP_PATH}/doLogin.do",
            beforeSend:function(){
                //一般做表单数据校验
                return true;
            },
            success:function(result){
                //请求成功后的回调函数
                //表示服务器端成功处理请求,并返回结果的处理
                if($("#ftype").val()=="member"){
                    window.location.href="${APP_PATH}/index.jsp";
                }else{
                    if(result.success){
                        window.location.href="${APP_PATH}/main.htm";
                    }else{
                        //alert("error");
                        alert(result.message);
                    }
                }
            },
            /*error:function(){
                //表示服务器端处理请求失败,执行相关操作
                alert("登录失败");
            }*/
        });

       /*var type = $(":selected").val();
        if ( type == "user" ) {
            window.location.href = "main.html";
        } else {
            window.location.href = "index.html";
        }*/
    }
</script>
</body>
</html>
