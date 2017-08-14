package com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class Task {

    // 每五秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long time = System.currentTimeMillis();
            String sql = "insert into base_supplies values(?,?,?,?,?,?,?,?,?)";
            connection = JdbcConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(time));
            preparedStatement.setString(2, "aa" + String.valueOf(time).substring(1,5));
            preparedStatement.setString(3, "name" + String.valueOf(time).substring(1,5));
            preparedStatement.setString(4, "4164646");
            preparedStatement.setString(5, "fafsdf");
            preparedStatement.setString(6, "31");
            preparedStatement.setString(7, "231");
            preparedStatement.setString(8, "fetwet");
            preparedStatement.setInt(9, 0);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }   finally {
                JdbcConnection.closeConnection(preparedStatement, connection);
        }
    }

}