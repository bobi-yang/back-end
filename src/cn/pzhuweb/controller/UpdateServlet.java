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

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        User user1 = (User) request.getSession().getAttribute("user");
        //封装一个用户对象
        if ("".equals(password1) || "".equals(password2)) {
            response.getWriter().print("<script>alert('密码不能为空！');window.location.href='update.jsp';</script>");
            return;
        }
        if (!password1.equals(password2)) {
            response.getWriter().print("<script>alert('两次密码不一致！');window.location.href='update.jsp';</script>");
            return;
        } else if (user1.getPassword().equals(password2)) {
            response.getWriter().print("<script>alert('新密码与原密码是一样的！');window.location.href='update.jsp';</script>");
            return;
        }
        User user = new User(name, password2);
        UserService us = new UserServiceImp();
        Message message = us.changePassword(user);
        response.getWriter().print("<script>alert('" + message.getMsg() + "');window.location.href='success.jsp';</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
