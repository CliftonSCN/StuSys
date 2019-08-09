<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layuiCommon/layuiTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>选课列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><%@include
	file="/WEB-INF/views/layuiCommon/layuiHeader.jsp"%>
</head>
<body>
	<div class="weadmin-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">选课管理</a>
			<a> <cite>选课列表</cite></a>
		</span> <a class="layui-btn layui-btn-sm"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="weadmin-body">

		<blockquote class="layui-elem-quote">选修课课程信息</blockquote>
		<table class="layui-table" id="elective_table">
			<thead>
				<tr>
					<th>id</th>
					<th id="th" ><div class="layui-table-cell laytable-cell-1-0-1">
							<span>课程名</span>
							<span id="sort" class="layui-table-sort layui-inline" lay-sort="">
								<i class="layui-edge layui-table-sort-asc" title="升序"></i>
								<i class="layui-edge layui-table-sort-desc" title="降序"></i>
							</span>
						</div></th>
					<th>剩余名额</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>详情页</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
	<script src="${APP_PATH }/lib/layui/layui.js" charset="utf-8"></script>
	<script src="${APP_PATH }/static/js/eleDel.js" type="text/javascript"
		charset="utf-8"></script>
	
	<script type="text/javascript">
		$(function() {
			getResult();
		});
		
		function getResult() {
			var span = $("#sort");
			var order = span.attr("lay-sort");
			$.ajax({
				url:"${APP_PATH}/elective/list",
				data:"order="+order,
				type:"GET",
				success:function(result){
					//建立表格
					build_emps_table(result);
				}
			})
		}
		
		function build_emps_table(result) {
			$("#elective_table tbody").empty();
			$.each(result, function(index,item) {
				var idTd = $("<td></td>").append(item.id);
				var elecNameTd = $("<td></td>").append(item.electiveName);
				var stockTd = $("<td></td>").append(item.stock);
				var startTd = $("<td></td>").append(item.startTime);
				var endTd = $("<td></td>").append(item.endTime);
				var detailBtn = $("<a class='layui-btn layui-btn-sm' title='详情' onclick='MyAdminShow(\"详情\"\,\"${APP_PATH }/elective/"+item.id+"/detail\")' href='javascript:;'><i class='layui-icon'>&#xe654;</i></a>");
				var btnTd = $("<td></td>").append(detailBtn);
				$("<tr></tr>").append(idTd).append(elecNameTd).append(stockTd)
				.append(startTd).append(endTd).append(btnTd)
				.appendTo("#elective_table tbody");
			});
		}; 
		
		$("#th").bind("click",function(){
			var span = $("#sort");
			var order = span.attr("lay-sort");
			if (order == "asc") {
				span.attr("lay-sort","desc");
			}else if (order == "desc") {
				span.attr("lay-sort","");
			}else{
				span.attr("lay-sort","asc");
			}
			getResult();
		});
	</script>
	<script type="text/javascript">
	    	function MyAdminShow(title, url, w, h) {
	    		if(title == null || title == '') {
	    			title = false;
	    		};
	    		if(url == null || url == '') {
	    			url = "404.html";
	    		};
	    		if(w == null || w == '') {
	    			w = ($(window).width() * 0.7);
	    		};
	    		if(h == null || h == '') {
	    			h = ($(window).height() - 200);
	    		};     
	    		 layer.open({
	    			type: 2,
	    			area: [w + 'px', h + 'px'],
	    			fix: false, //不固定
	    			maxmin: true,
	    			shadeClose: true,
	    			shade: 0.4,
	    			title: title,
	    			content: url,
	    	/* 		cancel: function(index, layero){ 

	    				  var title = layero.find('.layui-layer-title').text();
	    				  if (title == "编辑") {
	    				 	  if(confirm('确定要关闭么?')){ //只有当点击confirm框的确定时，该层才会关闭
	    					  var data = $(layero).find("iframe")[0].contentWindow.getData();
		    				  $.ajax({
		    				 		 url:"${APP_PATH }/admin/upCancel",
		    				 		 data:"fileName="+data,
		    				 		 success:function(){
		    				 			layer.close(index);
		    				 		 }
		    				  });
						   }
	    				  }else {
	    					  layer.close(index);
						  }
	    				  return false; 
	    				}  */  
	    		});
	    		
	    	}
		</script>
</body>
</html>