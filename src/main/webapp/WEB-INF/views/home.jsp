<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html ng-app="myapp">
<head>
	<title>Home</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
	<link rel="bookmark" href="/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/toaster.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ng-pagination.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/self.css"/>
	<base href="/">
</head>


<body ng-controller="mainCtrl">
<div class="header">
	<a href="javascript:void(0)" class="logo"><img src="/images/logo.png"></a>

	<div class="loginfont">

		<!--  TODO:show login info -->
		<div class="loginNameArea"><span style="font-size: 20px;">欢迎：<s:principal></s:principal></span><span style="margin-left: 20px;font-size: 20px;"><a
				href="javascript:void(0)" class="login" style="color: red;" ng-click="goLogout()">退出</a></span></div>

	</div>

</div>


<div>

	<side-menu-directive></side-menu-directive>

	<div id="content">
		<!-- stage is the key where the aimation work-->
		<div ui-view class="aaa"></div>
	</div>
</div>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/angular1.5.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/angular-ui-router.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/angular-animate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/ui-bootstrap-tpls-2.0.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/toaster.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/si-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jars/ng-pagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/services.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/controllers.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/directive.js"></script>
</html>