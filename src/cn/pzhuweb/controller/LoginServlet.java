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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        //封装一个用户对象
        User user = new User(name, password);
        //实现业务层接口
        UserService us = new UserServiceImp();
        //业务层调用login方法，返回一个message对象
        request.getSession().setAttribute("us", us);
        Message message = us.login(user);
        //判断用户数据是否正确。
        if (message.isSuccess()) {
            //为了让过滤器让行
            request.getSession().setAttribute("ok", "yes");
            //为了判断是否登录，显示功能菜单
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("username", user.getName());
            //信息错误进行警告提示框进行提示，没有问题则跳转success页面
            response.getWriter().print("<script>alert('" + message.getMsg() + "');window.location.href='success.jsp';</script>");
        } else {
            //有错误进行跳转登录页面，进行登录
            response.getWriter().print("<script>alert('" + message.getMsg() + "');window.location.href='login.jsp';</script>");
            //单引号里面只能可以嵌套双引号，双引号里面嵌套单引号
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
