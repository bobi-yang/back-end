package cn.pzhuweb.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static {
        InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = pro.getProperty("driver");
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");

        //1. 注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet res, Statement sta, Connection con) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet res, PreparedStatement sta, Connection con) {
        close(res, (Statement) sta, con);
    }

    public static void close(Statement sta, Connection con) {
        close(null, sta, con);
    }

    public static void close(PreparedStatement sta, Connection con) {
        close(null, (Statement) sta, con);
    }

}
