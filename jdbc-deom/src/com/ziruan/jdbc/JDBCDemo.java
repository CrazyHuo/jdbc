package com.ziruan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* JDBC快速入门
* */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义SQL
        String sql = "select * from job";

        Statement stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            String string1 = resultSet.getString(3);
            System.out.println(anInt+string+string1);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        // 测试


    }
}
