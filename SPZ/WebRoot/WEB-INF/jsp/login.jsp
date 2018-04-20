<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPZ's JSP</title>
    </head>
    <body>
    	<form action="dologin">
    		用户名：<input type="text" name="userName"/><br/>
    		密码:<input type="text" name="userPassword"/>
    		<button type="submit">登录</button>
    	</form>
 	</body>
</html>