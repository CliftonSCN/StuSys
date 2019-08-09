<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>用户登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <script type="text/javascript" src="${APP_PATH }/lib/jquery-1.12.4.min.js"></script>
    <link rel="shortcut icon" href="${APP_PATH }/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${APP_PATH }/static/css/font.css">
	<link rel="stylesheet" href="${APP_PATH }/static/css/weadmin.css">
    <script src="${APP_PATH }/lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">
    
    <div class="login">
        <div class="message">学生管理系统登录</div>
        <div id="darkbannerwrap"></div>
        <form id="login_form" method="post" class="layui-form" >
            <input id="userName" name="userName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="userPassword" name="userPassword" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input class="loginin" value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script type="text/javascript">
        	layui.extend({
				admin: '/stusys/static/js/admin'
			});
            layui.use(['form','admin'], function(){
              var form = layui.form
              	,admin = layui.admin;
              form.on('submit(login)', function(data){
       			$.ajax({
                	url:"${APP_PATH}/user/login",
                	data:$("#login_form").serialize(),
                	type:"POST",
                	success:function(result){
                		if (result.meta.success == true) {
                			window.location.href = "${APP_PATH}/index";
						}else {
							layer.msg(result.meta.message);
						}
                	}
                }); 
                return false;
              });
            });   
    </script>
    <!-- 底部结束 -->
</body>
</html>