<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/10/27
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误提示</title>
</head>
<script type="text/javascript">
    let i = 4;
    function show(){
        i=i-1;
        if(i>0){ document.getElementById("time").innerHTML=i+"秒后自动跳转登陆界面";
            setTimeout('show()',1000); }}
</script>
<body onload="show()">
<%
    if( session.getAttribute("error")!=null){
        out.print((String) session.getAttribute("error"));
        request.getSession().removeAttribute("error");
    }
    //检验用户名是否被登记过
    if(session.getAttribute("username")!=null){
        out.print((String) session.getAttribute("username"));
        session.removeAttribute("username");
    }
    response.setHeader("refresh", "3;url=login.jsp");//进行3s后自动刷新到登录页面
%>
<br>
<h3><span id="time">3s后跳转登陆页面</span></h3>
</body>
</html>
