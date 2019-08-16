<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layuiCommon/layuiTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生个人信息</title>
<%@include file="/WEB-INF/views/layuiCommon/layuiHeader.jsp"%>
<style type="text/css">
p{
	font-size: 17px;
}
</style>
</head>
<body>
	<div class="weadmin-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">个人中心</a>
			<a> <cite>个人信息</cite></a>
		</span> <a class="layui-btn layui-btn-sm"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<ul class="layui-timeline" style="margin-left: 100px;margin-top: 50px;">
		<li class="layui-timeline-item"><i
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h2 class="layui-timeline-title">基本信息</h3>
				<p>
					学号：${student.stuNum } <br>
					姓名：${student.stuName }<br>
					密码：<input type="hidden" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input" 
					style="width: 150px;vertical-align: middle;display: inline-block;height: 30px;"><a href="#" id="changePassword">更改密码</a>
					<!--  <i class="layui-icon"></i> -->
				</p>
			</div></li>
		<li class="layui-timeline-item"><i
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h2 class="layui-timeline-title">班级信息</h3>
				<p>
					入学时间：2016<br>
					院系：信息工程学院<br>
					专业：软件工程<br>
					班级：${student.stuClass.className }
				</p>
			</div></li>
		<li class="layui-timeline-item"><i
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text">
				<h2 class="layui-timeline-title">其他信息</h3>
				<p>
					性别：<c:if test="${student.stuGender == 1}">男</c:if>
						<c:if test="${student.stuGender == 2}">女</c:if><br>
					年龄：${student.stuAge}<br>
					联系方式<br>
					手机：${student.stuPhone }<br>
					邮箱：${student.stuEmail }
				</p>
			</div></li>
	</ul>
</body>
<script src="${APP_PATH }/static/js/eleDel.js" type="text/javascript"
		charset="utf-8"></script>
<script type="text/javascript">
$("#changePassword").bind("click",function(){
	var input = $(this).prev();
	input.attr("type","password");
	$(this).unbind();
	$("#changePassword").bind("click",function(){
		layui.use(['layer'], function(){
	  	layer = layui.layer;
	  		$.ajax({
	  			url:"${APP_PATH }/stu/changePassword",
	  			data:{stuNum:"${student.stuNum }",password:input.val()},
	  			success:function(res){
	  				layer.open({
	  			        type: 1
	  			        ,content: '<div style="padding: 20px 100px;">'+ res.meta.message +'</div>'
	  			        ,closeBtn: 0
	  			        ,btn: '关闭'
	  			        ,btnAlign: 'c'
	  			        ,shade: 0 
	  			        ,yes: function(){
	  			        	var href = location.href;
			  				href = href.substr(0, href.length - 1);
			  				location.replace(href);
	  			        }
	  			    });
	  			},
	  			error:function () {
	  				console.log("error");
	  			}
	  		});
		});
	});
});
</script>
</html>