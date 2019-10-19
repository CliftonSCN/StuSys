<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学生管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
			<meta http-equiv="Cache-Control" content="no-siteapp" />
			<link rel="shortcut icon" href="${APP_PATH }/favicon.ico"
				type="image/x-icon" />
			<link rel="stylesheet" href="${APP_PATH }/static/css/font.css">
				<link rel="stylesheet" href="${APP_PATH }/static/css/weadmin.css">
					<script type="text/javascript"
						src="${APP_PATH }/lib/layui/layui.js" charset="utf-8"></script>
</head>

<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="#">StuSYS</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		<ul class="layui-nav right" lay-filter="">
			<shiro:notAuthenticated>
				<a href="login.jsp">请先登录！</a>
			</shiro:notAuthenticated>
			<shiro:authenticated>
				<li class="layui-nav-item"><a href="javascript:;"><shiro:principal /></a>
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd>
							<a href="#"
								onclick="WeAdminShow('个人信息','${APP_PATH }/stu/home',1100,700)">个人信息</a>
						</dd>
						<dd>
							<a class="loginout" href="user/logout">退出</a>
						</dd>
					</dl></li>
			</shiro:authenticated>

		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
						<cite>个人中心</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="stu/home"> <i class="iconfont">&#xe6a7;</i>
								<cite>个人信息</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="stu/course"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>课程信息</del></cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="stu/stuScore"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>成绩查询</del></cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="stu/toAppraise"> <i class="iconfont">&#xe6a7;</i>
								<cite>教学评优</cite>
						</a></li>
					</ul></li>

				<li><a href="javascript:;"> <i class="iconfont">&#xe705;</i>
						<cite>选课管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="elective/toList"> <i class="iconfont">&#xe6a7;</i>
								<cite>选课列表</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="elective/Elevtived"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>已选课程</del></cite>
						</a></li>
					</ul></li>

				<li><a href="javascript:;"> <i class="iconfont">&#xe6ce;</i>
						<cite>教师操作</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="tc/tcScore"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>成绩录入</del></cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="tc/appraise"> <i class="iconfont">&#xe6a7;</i>
								<cite>评优结果</cite>
						</a></li>
					</ul></li>

				<li><a href="javascript:;"> <i class="iconfont">&#xe6ce;</i>
						<cite>管理中心</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="admin/userList"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>用户信息</del></cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="admin/stuList"> <i class="iconfont">&#xe6a7;</i>
								<cite>学生信息</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="admin/classList"> <i class="iconfont">&#xe6a7;</i>
								<cite>班级信息</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="admin/tcList"> <i class="iconfont">&#xe6a7;</i>
								<cite><del>教师信息</del></cite>
						</a></li>
					</ul></li>

			</ul>
		</div>
	</div>
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip"
			lay-allowclose="true">
			<ul class="layui-tab-title" id="tabName">
				<li>主页面</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='user/welcome' frameborder="0" scrolling="yes"
						class="weIframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">©2019 StuSYS v1.0</div>
	</div>
	<!-- 底部结束 -->
	<script type="text/javascript">
		layui.config({
			base : '${APP_PATH }/static/js/',
			version : '101100'
		}).use('admin');
		layui.use([ 'jquery', 'admin' ], function() {
		});
	</script>
</body>
<!--Tab菜单右键弹出菜单-->
<ul class="rightMenu" id="rightMenu">
	<li data-type="fresh">刷新</li>
	<li data-type="current">关闭当前</li>
	<li data-type="other">关闭其它</li>
	<li data-type="all">关闭所有</li>
</ul>

</html>