package com.task;

import java.sql.*;

/**
 * Created by pc on 2017/8/10.
 */
public class JdbcConnection {

    //获取数据库连接
    public static Connection getConnection() throws Exception {
        // 日志
        String driverName = new ConfigUtil().getConfig("driver");
        String dbURL = new ConfigUtil().getConfig("url");
        String userName = new ConfigUtil().getConfig("username");
        String userPwd = new ConfigUtil().getConfig("password");
        Connection dbConn = null;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConn;
    }

    // 关闭数据库连接，注意关闭的顺序
    public static void closeConnection(PreparedStatement ps, Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
