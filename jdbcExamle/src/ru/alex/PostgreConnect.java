package ru.alex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnect {

    public static Connection returnConnection(String url,String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("PostgreSQL JDBC Driver is not found.");
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        return connection;
    }

}
