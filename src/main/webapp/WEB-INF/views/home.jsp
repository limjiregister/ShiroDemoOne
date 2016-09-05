<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myapp">
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/self.css"/>
</head>
<body>

<div class="header">
	<a href="javascript:void(0)" class="logo"><img src="/images/logo.png"></a>

	<div class="loginfont">
		<ul>
			<li><a href="javascript:void(0)" class="login">登录</a></li>
			<li><a href="javascript:void(0)">注册</a></li>
		</ul>
	</div>

</div>


<%--<div id="side">--%>
	<%--<ul>--%>
		<%--<li><a ui-sref="doLogin">用户管理</a></li>--%>
	<%--</ul>--%>
<%--</div>--%>
<div id="content">
	<!-- stage is the key where the aimation work-->
	<div ui-view class="aaa"></div>
</div>



<%--

<p><a href="add.req">add page</a></p>
<p><a href="second.req">踏上第二页</a></p>
<p><a href="third.req">踏上第三页</a></p>
--%>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/angular1.5.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/angular-ui-router.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/ui-bootstrap-tpls-2.0.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/directive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/services.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/controllers.js"></script>
</html>
