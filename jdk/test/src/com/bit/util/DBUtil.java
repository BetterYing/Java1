package com.bit.util;

import java.math.BigDecimal;
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args)  {
        //String input = "'孙悟空' or l = 1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select id,name,chinese,math,english from exam_result";

            //ResultSet类似于LIstanbul<Map<String,Object>>
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese =  resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id = %s,name = %s,chinese = %s,math = %s,english = %s",id,name,chinese,math,english);
                System.out.println();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
