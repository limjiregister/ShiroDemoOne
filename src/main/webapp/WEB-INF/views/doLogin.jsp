<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Login page</title>
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

<div id="loginBody">
	<h1>login page</h1>
	<form id="" action="dologin.req" method="post">
		<label>User Name</label> <input tyep="text" name="userName" maxLength="40"/>
		<label>Password</label><input type="password" name="password"/>
		<input type="submit" value="login"/>
	</form>
</div>
</body>
</html>
