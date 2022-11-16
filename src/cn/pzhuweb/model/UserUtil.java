package cn.pzhuweb.model;

import cn.pzhuweb.pojo.Message;
import cn.pzhuweb.pojo.User;

public class UserUtil {
    //1,判断username是否合法
    public static Message check(User userInfo) {
        if (userInfo == null) {
            return new Message(false, "用户数据不合法！");

        }
        if (userInfo.getName().equals("")) {
            return new Message(false, "用户名不能为空！");
        }
        //补充age，hobby。

        if (userInfo.getPassword().equals("")) {
            return new Message(false, "密码不能为空！");
        }
        return new Message(true, "数据合法");
    }
}
