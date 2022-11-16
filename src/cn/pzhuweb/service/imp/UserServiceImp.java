package cn.pzhuweb.service.imp;

import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.dao.imp.UserDAOImp;
import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;
import cn.pzhuweb.service.UserService;

public class UserServiceImp implements UserService {

    private UserDAO dao = new UserDAOImp();

    //注册功能
    @Override
    public Message login(User user) {
        // TODO Auto-generated method stub
        if (user == null) {
            return new Message(false, "数据不合法");
        }
        if ("".equals(user.getName()) || "".equals(user.getPassword())) {
            return new Message(false, "用户名或者密码不能为空！");
        }
        User dbUser = dao.selectById(user.getName());//返回数据库中的一个user对象
        if (dbUser == null) {
            return new Message(false, "用户名不存在！");
        }
        //比较数据库里面的用户对象密码和当前登录的用户密码
        if (!dbUser.getPassword().equals(user.getPassword())) {
            return new Message(false, "密码错误！");
        }
        return new Message(true, "登录成功！");
    }

    //注册功能
    @Override
    public Message register(User user) {
        // TODO Auto-generated method stub
        int num = dao.insert(user);
        if (num > 0) {
            return new Message(true, "恭喜，注册成功！");
        } else {
            return new Message(false, "注册失败！");
        }
    }

    //修改密码
    @Override
    public Message changePassword(User user) {
        // TODO Auto-generated method stub
        int num = dao.update(user);
        if (num > 0) {
            return new Message(true, "修改密码成功！");
        } else {
            return new Message(false, "修改密码失败！");
        }
    }

    //删除用户
    @Override
    public Message removeAccount(String name) {
        // TODO Auto-generated method stub
        int num = dao.delete(name);
        if (num > 0) {
            return new Message(true, "确定要删除这个数据吗？");
        } else {
            return new Message(false, "删除失败！");
        }
    }


}
