package cn.pzhuweb.service;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;

public interface UserService {
    //1用户登录
    public Message login(User user);

    //2用户注册
    public Message register(User user);

    //3修改密码
    public Message changePassword(User user);

    //4销户
    public Message removeAccount(String name);
}
