<%@ page import="cn.pzhuweb.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        li{
            display: inline-block;
            padding-right: 30px;
        }
        li>a{
            color: red;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div style="height: 50px;background-color: #cdcdcd">
    <ul style="float: left;">
        <c:if test="${not empty user}">
            <li><a href="update.jsp">修改密码</a></li>
            <li><a href="destroy.jsp">销毁账户</a></li>
        </c:if>
    </ul>

    <ul style="float: right;">
        <c:if test="${empty user}">
            <li><a href="login.jsp">登录</a></li>
            <li><a href="register.jsp">注册</a></li>
        </c:if>

        <c:if test="${not empty user}">
            <li>用户：${user.name}</li>
            <li><a href="login.jsp">退出</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>