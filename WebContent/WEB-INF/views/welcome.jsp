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
		<meta charset="UTF-8">
		<title>YouTao</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${APP_PATH }/static/css/font.css">
		<link rel="stylesheet" href="${APP_PATH }/static/css/weadmin.css">
	</head>

	<body>
		<div class="weadmin-body">
			<div class="layui-fluid" style="overflow: hidden;">
				<div class="layui-row layui-col-space15">
					<div class="layui-col-md7">
						<!--WeAdmin公告-->
						<div class="layui-card">
							<div class="layui-card-header layui-elem-quote">公告</div>
							<div class="layui-card-body">
								<div class="layui-carousel weadmin-notice" lay-filter="notice" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
									<div carousel-item="">
										<div class="">
											<a href="#" target="_blank" class="layui-bg-red">欢迎使用YouTao</a>
										</div>
										<div class="">
											<a href="https://www.baidu.com" target="_blank" class="layui-bg-blue">YouTao帮助手册</a>
										</div>
										<div class="">
											<a href="https://www.baidu.com" target="_blank" class="layui-bg-green">了解YouTao</a>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="layui-col-md5">
						<div class="layui-card">
							<div class="layui-card-header">
								作者叨叨
								<i class="layui-icon" style="color: #FF5722;">&#xe756;</i>
							</div>
							<div class="layui-card-body layui-text weadmin-text">
								<p>YouTao</p>
								<p>虽然名字叫YouTao，但并不是一个卖油桃的。</p>
								<p>咱们是做管理的。</a></p>				
							</div>
						</div>
					</div>
				</div>
			</div>
			<div style="clear: both;overflow: hidden;margin-left: 15px;margin-right: 15px;">
				<blockquote class="layui-elem-quote">欢迎使用YouTao后台管理系统
				</blockquote>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${APP_PATH }/lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
		layui.extend({
			admin: '${APP_PATH }/static/js/admin',
		});
		layui.use(['jquery', 'element','util', 'admin', 'carousel'], function() {
			var element = layui.element,
				$ = layui.jquery,
				carousel = layui.carousel,
				util = layui.util,
				admin = layui.admin;
			
			carousel.render({
				elem: '.weadmin-notice'
				,width: '100%' //设置容器宽度				
				,arrow: 'none' //始终显示箭头	
				,trigger: 'hover'
				,interval: 2500
				,anim: 'fade'
				,autoplay:true
			});
			
			$(function(){
				setTimeAgo(2018,0,1,13,14,0,'#firstTime');
				setTimeAgo(2018,2,28,16,0,0,'#lastTime');
			});
			function setTimeAgo(y, M, d, H, m, s,id){
			    var str = util.timeAgo(new Date(y, M||0, d||1, H||0, m||0, s||0));
			    $(id).html(str);
			    console.log(str);
			 };
		});
	</script>

</html>