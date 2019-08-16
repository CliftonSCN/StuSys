<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layuiCommon/layuiTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学评优</title>
<%@include file="/WEB-INF/views/layuiCommon/layuiHeader.jsp"%>
</head>
<body>
	<div class="weadmin-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">个人中心</a>
			<a> <cite>教学评优</cite></a>
		</span> <a class="layui-btn layui-btn-sm"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="weadmin-body">
		<div class="layui-tab layui-tab-brief" lay-filter="tcTab">
			<blockquote class="layui-elem-quote">教师选项卡</blockquote>
			<ul class="layui-tab-title" id="tab_tc">
				
			</ul>
			<div class="layui-tab-content" style="height: 100px;" id="div_tc">
				
			</div>
		</div>
	<script src="${APP_PATH }/static/js/eleDel.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url:"${APP_PATH }/stu/getTeachers",
				type:"GET",
				success:function(res){
					build_ul(res);
				}
			});
		});
		
		function build_ul(res) {
			$("#tab_tc").empty();
			$("#div_tc").empty();
			//在选项卡头上标记
			$.each(res, function(index,item) {
				var li = $("<li></li>").append(item.tcName).appendTo("#tab_tc");
				var div = $("<div class='layui-tab-item'></div>").append("<iframe frameborder='0' src='${APP_PATH }/stu/toGrade?id="+item.tcNum+"&fin="+item.fin+"' scrolling='no' class='weIframe' style='width: 100%; height: 400px;'></iframe>").appendTo("#div_tc");
				if (index == 0) {
					li.attr("class","layui-this");
					div.addClass("layui-show");
				}
			});
		}
				
	</script>
	<script type="text/javascript">
		layui.use('element', function() {
			var element = layui.element;

			//一些事件监听
			element.on('tab(tcTab)', function(data) {
				console.log(data);
				console.log(this); //当前Tab标题所在的原始DOM元素
				console.log(data.index); //得到当前Tab的所在下标
				console.log(data.elem); //得到当前的Tab大容器
			});
		});
	</script>
</body>
</html>