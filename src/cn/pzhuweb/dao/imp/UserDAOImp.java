package cn.pzhuweb.dao.imp;

import cn.pzhuweb.Util.JDBCUtil;
import cn.pzhuweb.dao.UserDAO;
import cn.pzhuweb.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImp implements UserDAO {
    @Override
    public int insert(User t) {
        Connection con = JDBCUtil.getConnection();
        String sql = "insert into user values(?,?)";//让？代替参数
        PreparedStatement psta = null;
        try {
            psta = con.prepareStatement(sql);
            psta.setString(1, t.getName());//给指定问号参数赋值
            psta.setString(2, t.getPassword());
            return psta.executeUpdate();//返回一个整数值，指受到影响的行数
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(psta, con);
        }
        return 0;
    }

    @Override
    public int delete(String k) {
        // TODO Auto-generated method stub
        Connection con = JDBCUtil.getConnection();
        String sql = "DELETE FROM user WHERE name = ?";
        PreparedStatement psta = null;
        try {
            psta = con.prepareStatement(sql);
            psta.setString(1, k);
            return psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(psta, con);
        }
        return 0;
    }

    @Override
    public int update(User t) {
        // TODO Auto-generated method stub
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE user SET password = ? WHERE name = ?";//根据寻找用户名修改密码
        PreparedStatement psta = null;
        try {
            psta = con.prepareStatement(sql);
            psta.setString(2, t.getName());//将第二个？赋值
            psta.setString(1, t.getPassword());
            return psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(psta, con);
        }
        return 0;
    }

    @Override
    public List<User> select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User selectById(String k) {
        // TODO Auto-generated method stub
        Connection con = JDBCUtil.getConnection();
        PreparedStatement psta = null;
        ResultSet rs = null;
        String sql = "select *from user where name=?";
        try {
            psta = con.prepareStatement(sql);
            //设置数据库表中的name一个值
            psta.setString(1, k);//给问号赋值
            rs = psta.executeQuery();
            //如果指针下面还有数据，代码执行
            if (rs.next() != false) {
                String name = rs.getString(1);
                String password = rs.getString(2);
                return new User(name, password);//封装成一个数据库user对象返回
            } else {
                return null;//用户不存在
            }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        } finally {
            JDBCUtil.close(rs, psta, con);
        }

    }

}
