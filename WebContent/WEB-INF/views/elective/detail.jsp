<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>选课详情页</title>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <link rel="stylesheet" href="/stusys/static/css/font.css">
	<link rel="stylesheet" href="/stusys/static/css/weadmin.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center" style="margin-top: 10%;border: none; box-shadow: 0px;">
        <div class="pannel-heading">
            <h1>课程名：${elective.electiveName}</h1>
        </div>

        <div class="panel-body">
            <h2 class="text-danger">
                <%--显示time图标--%>
                <span class="glyphicon glyphicon-time" style="vertical-align: middle;"></span>
                <%--展示倒计时--%>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>

</body>
<%--jQery文件,务必在bootstrap.min.js之前引入--%>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<%--jQuery Cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown倒计时插件--%>
<script src="https://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/seckill.js"></script>

<script type="text/javascript">
    jQuery(function() {
        //使用EL表达式传入参数
        seckill.detail.init({
            seckillId:${elective.id},
            startTime:${elective.startTime.time},//毫秒
            endTime:${elective.endTime.time},
        });
    });
</script>
</html>