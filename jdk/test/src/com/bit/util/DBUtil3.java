package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil3 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            DataSource ds = new MysqlDataSource();

            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "insert into exam_result(id,name,chinese,math,english) value (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,8);
            statement.setString(2,"ABC");
            statement.setBigDecimal(3,new BigDecimal(60));
            statement.setBigDecimal(4,new BigDecimal(61));
            statement.setBigDecimal(5,new BigDecimal(62));

            System.out.println(sql);

            int num = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

