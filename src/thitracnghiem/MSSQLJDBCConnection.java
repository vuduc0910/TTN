package thitracnghiem;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vuduc
 */
public class MSSQLJDBCConnection {
    public static Connection getJDBCConnection()
    {
        String username = "sa";
        String password = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTTN";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");   
            return DriverManager.getConnection(url,username,password);           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MSSQLJDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
