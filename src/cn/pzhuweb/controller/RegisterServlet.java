package cn.pzhuweb.controller;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.service.UserService;
import cn.pzhuweb.service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username1");
        String password = request.getParameter("password");
        //封装一个用户对象
        User user1 = new User(name, password);
        //实现业务层接口
        UserService us = new UserServiceImp();
        //业务层调用register方法，返回一个message对象
        Message message = us.register(user1);
        if (message.isSuccess()) {
            response.getWriter().print("<script>alert('" + message.getMsg() + "');window.location.href='login.jsp';</script>");
        }
        response.getWriter().print("<script>alert('" + message.getMsg() + "');window.location.href='register.jsp';</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
