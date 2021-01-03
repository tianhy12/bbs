package com.bdqn.bbs.util;

import java.sql.*;

public class BaseDao {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private ResultSet resultSet;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        try {
            if (connection==null)
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "pig", "Thy123456.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public ResultSet executeQuery(String sql,Object... params){
        connection=getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i<params.length;i++)
                preparedStatement.setObject(i+1,params[i]);
            return preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public int executeUpdate(String sql,Object... params){
        connection=getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i<params.length;i++)
                preparedStatement.setObject(i+1,params[i]);
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
