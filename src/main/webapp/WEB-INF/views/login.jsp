<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html ng-app="myapp">
<head>
	<title>Login page</title>
</head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
<link rel="bookmark" href="/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/toaster.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/self.css"/>
<body ng-controller="mainCtrl">

<div class="header">
	<a href="javascript:void(0)" class="logo"><img src="/images/logo.png"></a>

	<div class="loginfont">

		<ul>
			<li><a href="javascript:void(0)" class="login">请登录.....</a></li>
		</ul>

	</div>

</div>

<toaster-container style="top: 300px !important;right: 680px;"></toaster-container>

<div id="loginBody">

	<div class="form-top">
		<div class="form-top-left">
			<h3>WELCOME LOGIN SYSTEM</h3>
			<p>Enter your username and password to log on:</p>
		</div>
		<div class="form-top-right">
			<i class="fa fa-lock"></i>
		</div>
	</div>

	<div class="form-bottom">
		<form class="login-form" name="form-host" ng-submit="goLogin()">
			<div class="form-group">
				<label class="sr-only" for="form-username">Username</label>
				<input type="text" name="form-username" placeholder="Username..." class="form-username form-control"
					   id="form-username" ng-model="loginInfo.userName" ng-required="true">
			</div>
			<div class="form-group">
				<label class="sr-only" for="form-password">Password</label>
				<input type="password" name="form-password" placeholder="Password..."
					   class="form-password form-control" id="form-password" ng-model="loginInfo.password"
					   ng-required="true">
			</div>
			<button type="submit" class="btn" ng-disabled="login-form.$invalid">登陆</button>
		</form>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/directive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/services.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/controllers.js"></script>
</html>
