<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/11/9
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <style type="text/css">
        body{
            text-align: center;}
        table{margin: auto;}
    </style>
</head>
<jsp:include page="head.jsp"/>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="button" value="注册"/>&nbsp;&nbsp;<input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
