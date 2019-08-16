<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layuiCommon/layuiTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/layuiCommon/layuiHeader.jsp"%>

</head>
<body>
	<div class="weadmin-body">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 30px;">
			<legend>上课下课按时</legend>
		</fieldset>
		<div class="layui-row">
			<div class="layui-col-md3 layui-col-md-offset1">
				<div class="grid-demo grid-demo-bg1">
					<div id="param1"></div>
				</div>
			</div>
		</div>
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 30px;">
			<legend>启发思维、条理清楚</legend>
		</fieldset>
		<div class="layui-col-md3 layui-col-md-offset1">
			<div class="grid-demo grid-demo-bg1">
				<div id="param2"></div>
			</div>
		</div>
		<br> <br>
	</div>
	<button type="button" id="btn_submit" style="margin-left: 350px;"
		class="layui-btn layui-btn-primary layui-btn-radius">提交</button>

	<script>
		$(function() {
			if (${fin} == 0) {
				//获取具体的分数
				$.ajax({
					url:"${APP_PATH}/stu/getGrade",
					type:"GET",
					data:{"id":"${id}"},
					success:function(res){
						
					}
				});
				$("#param1").replaceWith("<h2>你选择了：3分</h2>");
				$("#param2").replaceWith("<h2>你选择了：3分</h2>");
			}
		});
	
	
		/**
		 * Map转json
		 * @param m
		 * @returns String
		 */
		function MapTOJson(m) {
			var str = '{';
			var i = 1;
			m.forEach(function(item, key, mapObj) {
				if (mapObj.size == i) {
					str += '"' + key + '":"' + item + '"';
				} else {
					str += '"' + key + '":"' + item + '",';
				}
				i++;
			});
			str += '}';
			return str;
		};
		var map = new Map();
		layui.use([ 'rate' ], function() {
			var rate = layui.rate;
			rate.render({
				elem : '#param1',
				value : 3,
				text : true,
				setText : function(value) {
					this.span.text(value + "分");
					map.set("param1", value);
				}
			});

			rate.render({
				elem : '#param2',
				value : 3,
				text : true,
				setText : function(value) {
					this.span.text(value + "分");
					map.set("param2", value);
				}
			});
		});

		$("#btn_submit").click(function() {
			var str = MapTOJson(map);
			$.ajax({
				url : "${APP_PATH }/stu/appraise",
				type : "POST",
				data : {"data":str,"id":"${id}"},
				success : function() {
					$("#param1").replaceWith("<h2>你选择了："+map.get("param1")+"分</h2>");
					$("#param2").replaceWith("<h2>你选择了："+map.get("param2")+"分</h2>");
				}
			});
			return false;
		});
	</script>
</body>
</html>