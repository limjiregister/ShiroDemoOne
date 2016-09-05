<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Login page</title>
</head>
<body>


<h1>login page</h1>
<form id="" action="dologin.req" method="post">
	<label>User Name</label> <input tyep="text" name="userName" maxLength="40"/>
	<label>Password</label><input type="password" name="password"/>
	<input type="submit" value="login"/>
</form>

</body>
</html>
