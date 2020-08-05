package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    public Connection getDbConnect(){
        Connection con=null;
        try {
            String host = "jdbc:mysql://localhost:3306/petshop";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(host,username,password);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
