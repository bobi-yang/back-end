<%@ page import="cn.pzhuweb.pojo.User" %>
<%@ page import="cn.pzhuweb.service.UserService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>摧毁数据页面</title>
    <script>
        if(confirm("确定要删除该用户数据吗？")){
            <%
            User user=(User)request.getSession().getAttribute("user");
            UserService us=(UserService)request.getSession().getAttribute("us");
            us.removeAccount(user.getName());
            request.getSession().removeAttribute("user");
            %>
            alert("删除成功！");
            window.location.href='login.jsp';
        }else{
            window.location.href='success.jsp';
        }
    </script>
</head>
<body>
</body>
</html>