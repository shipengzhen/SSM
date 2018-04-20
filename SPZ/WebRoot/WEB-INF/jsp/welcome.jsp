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
    	<h1>欢迎${user.userName}</h1>
    	<a href="spz?userName=${user.userName}">spz</a>
 	</body>
</html>