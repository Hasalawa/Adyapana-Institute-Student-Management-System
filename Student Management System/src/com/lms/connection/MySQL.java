/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author KEHAN HASALAWA
 */
public class MySQL {
    
    private static Connection connection;
    
    public static void getConnection() throws Exception{
        
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adyapana","root","Kh@17052002");
        }

    }
    
    public static Integer executeIUD(String query) throws Exception{
        getConnection();
        return connection.createStatement().executeUpdate(query);
    }
    
    public static ResultSet executeSearch(String query) throws Exception{
        getConnection();
        return connection.createStatement().executeQuery(query);
    }
    
}
