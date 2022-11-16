<%@ page import="cn.pzhuweb.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <style type="text/css">
        body{
            text-align: center;
        }
        table{
            margin: auto;
        }
    </style>
</head>
<jsp:include page="head.jsp"/>
<body >
<form action="UpdateServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="user-name-label" value="${user.name}"/></td>
        </tr>
        <tr>
            <td>输入密码：</td>
            <td><input type="password" name="password1"/></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" name="password2"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="button" value="返回"/>&nbsp;&nbsp;<input type="submit" value="修改密码"/></td>
        </tr>
    </table>
</form>
</body>
</html>