<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
</head>
<jsp:include page="head.jsp"/>
<body>
欢迎${user.name}登录，点击<a href="destroy.jsp">这里</a>注销账号！
</body>
</html>