<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>学生列表</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${APP_PATH }/static/css/font.css">
		<link rel="stylesheet" href="${APP_PATH }/static/css/weadmin.css">
		<script type="text/javascript" src="${APP_PATH }/lib/jquery-1.12.4.min.js"></script>
	</head>

	<body>
		<div class="weadmin-nav">
			<span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">学生管理</a>
        <a>
          <cite>学生列表</cite></a>
      </span>
			<a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
				<i class="layui-icon" style="line-height:30px">ဂ</i></a>
		</div>
		<div class="weadmin-body">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search" action="${APP_PATH }/admin/search" method="post">
					<div class="layui-input-inline">
      					<input type="text" class="layui-input" id="start" name="start" placeholder="开始日" autocomplete="off">
     				</div>
					<div class="layui-input-inline">
						<input type="text" class="layui-input" placeholder="截止日" name="end" id="end" autocomplete="off">
					</div>
					<div class="layui-inline">
						<input type="text" id="account" name="account" placeholder="请输入用户名" autocomplete="off" class="layui-input">
					</div>
					<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
				</form>
			</div>
			<div class="weadmin-block">
				<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
				<button class="layui-btn" onclick="MyAdminShow('添加用户','add')"><i class="layui-icon"></i>添加</button>
				<button type="button" class="layui-btn layui-btn-normal" id="upload_prepare">选择(.xlsx)文件</button>
				<button type="button" class="layui-btn" id="upload_start" onclick="">开始上传</button>
				<div id="bar_process" class="layui-progress layui-progress-big" lay-filter="demo" lay-showpercent="true"  style="width: 300px;vertical-align: middle;display: none;">
				  <div class="layui-progress-bar" lay-percent="0%" ></div>
				</div>
				<button id="btn_import" class="fr layui-btn layui-btn-warm" onclick="importAll()"><i class="layui-icon"></i>一键录入</button>
				<span class="fr" style="line-height:40px;margin-right: 10px;">共有数据：${pageInfo.total } 条</span>
			</div>
			<!-- 表格开始 -->
			<table class="layui-table" id="admin_table" lay-filter="table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>班级</th>
						<th>手机</th>
						<th>邮箱</th>
						<th>操作</th>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="stu">
						<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='1'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td>${stu.stuNum }</td>
						<td>${stu.stuName }</td>
						<td>
							<c:if test="${stu.stuGender == 1 }">男</c:if>
							<c:if test="${stu.stuGender == 2 }">女</c:if>
						</td>
						<td>${stu.stuAge }</td>
						<td>${stu.stuClass.className }</td>
						<%-- <td><fmt:formatDate value="${stu.adminCreatetime }" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
						<td>${stu.stuPhone }</td>
						<td>${stu.stuEmail }</td>
						<td class="td-manage">
							<a title="编辑" onclick="MyAdminShow('编辑','edit?adminId= ${admin.adminId }')" href="javascript:;">
								<i class="layui-icon">&#xe642;</i>
							</a>
							<%-- <a class="deleteAdmin" msg="${admin.adminAccount }" index="${admin.adminId }" href="#"  title="删除" > --%>
							<a onclick="del_admin(${admin.adminId },'${admin.adminAccount }')" href="#"  title="删除" >
								<i class="layui-icon">&#xe640;</i>
							</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 表格结束 -->
			<!-- 分页开始 -->
			<div class="page">
				<div>
					<c:if test="${pageInfo.hasPreviousPage }">
				  		<a class="prev" href="${APP_PATH }/admin/stuList?pn=${pageInfo.pageNum-1 }">&lt;&lt;</a>
				  	</c:if>
				  	<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
				    	<c:if test="${page_Num == pageInfo.pageNum }">
				    		<span class="current">${page_Num }</span>
				    	</c:if>
				    	<c:if test="${page_Num != pageInfo.pageNum }">
				    		<a class="num" href="${APP_PATH }/admin/stuList?pn=${page_Num }">${page_Num }</a>
				    	</c:if>
				    </c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<a class="next" href="${APP_PATH }/admin/stuList?pn=${pageInfo.pageNum+1 }">&gt;&gt;</a>
				  	</c:if>
				</div>
			</div>
			<!-- 分页结束 -->
		</div>
		<script src="${APP_PATH }/lib/layui/layui.js" charset="utf-8"></script>
    	<script src="${APP_PATH }/static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
    	
    	<script type="text/javascript">
	    	layui.use('upload', function(){
	    		  var $ = layui.jquery
	    		  ,upload = layui.upload;
		    	upload.render({
		    	    elem: '#upload_prepare'
		    	    ,url: '${APP_PATH }/admin/uploadExcel'
		    	    ,accept: 'file'
		    	    ,exts:'xlsx'
		    	    ,method: 'POST'
		    	    ,auto: false
		    	    ,bindAction: '#upload_start'
		    	    ,choose: function(obj){
		    	    	$("#upload_start").attr("onclick", "upload_start()");
		    	    	obj.preview(function(index, file, result){
		    	    	      var span = $("<span class='layui-inline layui-upload-choose'>"+file.name+"</span>");
		    	    	      $("#upload_start").before(span);
		    	    	});
		    	    }
		    	    ,done: function(res){
		    	      layer.msg(res.meta.message);
		    	    }
		    	    ,error: function(res) {
		    	    	layer.msg(res.meta.message);
					}
		    	  });
	    	});
    	</script>
    	<script type="text/javascript">
			var clock = '';
 			var bar_process = $("#bar_process");
			function upload_start() {
				clock = setInterval(updateProcess,500);
				bar_process.css("display","inline-block");
			};
		
		function updateProcess() {
			$.ajax({
				url:"${APP_PATH }/admin/getProcess",
				method: 'GET',
				success:function(res){
					layui.use('element', function(){
						  var $ = layui.jquery
						  ,element = layui.element;
						if (res != null && res != "" && res != "error") {
							if (res == "100%") {
								clearInterval(clock);
								setTimeout(delProcess,200);
							}
							element.progress('demo', res);
						}else if (res == "error") {
							clearInterval(clock);
							$.ajax({
								url:"${APP_PATH }/admin/delProcess",
								method:"DELETE",
								type:"json",
								data:JSON.stringify({error:'error'}),
								success:function(res){
									layer.msg(res.meta.message);
									bar_process.css("display","none");
									bar_process.children().first().children().first().text("0%");
									element.progress('demo', "0%");
								}
							});
						}else {
							element.progress('demo', "5%");
						}
					}); 
				}
			});
		}
		
		function delProcess() {
			$.ajax({
				url:"${APP_PATH }/admin/delProcess",
				method:"DELETE",
				success:function(res){
					layer.msg(res.meta.message);
					bar_process.css("display","none");
					bar_process.children().first().children().first().text("0%");
					layui.use('element', function(){
						  var $ = layui.jquery
						  ,element = layui.element;
						  element.progress('demo', "0%");
					});
				}
			});
		}
		
    	
    		function del_admin(adminId,adminAccount){
    			var msg = "确认要删除 "+adminAccount+" 吗?";
    			layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
    				$.ajax({
    					url:"${APP_PATH}/admin/deleteOne",
    					data:"adminId="+adminId,
    					type:"post",
    					success:function(){
    						layer.close(index);
    						parent.location.reload();
    					}
    				});
    				  
    				});   
				return false;
    		};
    	</script>
    	<script type="text/javascript">
    		function importAll() {
    			var btn_import = $("#btn_import");
    			btn_import.addClass("layui-btn-disabled");
    			btn_import.text("录入中");
				$.ajax({
					url:"${APP_PATH}/admin/importStuBatch",
					type:"GET",
					success:function(res){
						layer.msg(res.meta.message);
						btn_import.removeClass("layui-btn-disabled");
						btn_import.text("一键录入");
					}
				});
			}
    	
			function delAll() {
				var data = tableCheck.getData();
				if (data == "" || data == null) {
					layer.alert('请选择数据');
				}else {
					layer.confirm('确认要删除这些数据吗？', function(index) {
						//捉到所有被选中的，发异步进行删除
						$.ajax({
							url:"${APP_PATH}/admin/deleteAll",
	    					data:"list="+data,
	    					type:"post",
	    					success:function(){
	    						layer.close(index);
	    						parent.location.reload();
	    					}
						})
					});
				}
			}
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
	    			w = ($(window).width() * 0.9);
	    		};
	    		if(h == null || h == '') {
	    			h = ($(window).height() - 50);
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
	    			cancel: function(index, layero){ 

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
	    				}   
	    		});
	    		
	    	}
			layui.use('laydate', function(){
  			var laydate = layui.laydate;
				laydate.render({
	    			elem: '#start'
	    			,type: 'datetime'
  				});
				laydate.render({
	    			elem: '#end'
	    			,type: 'datetime'
	  			});
			});
		</script>
	</body>

</html>