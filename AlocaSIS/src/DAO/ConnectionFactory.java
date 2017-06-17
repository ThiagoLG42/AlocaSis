/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sigma development
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String URL = "jdbc:mysql://localhost:3306/alocasis"; 
    private static final String USER = "root"; 
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Exceção: ", ex);
        }
    }
    
    public static void closeConnetion(Connection con){
        try {
            if (con != null) {
                con.close();
            } 
        }catch (SQLException ex) {
            System.out.println("Execeção: "+ex);    
            
        }
    }
    
    public static void closeConnetion(Connection con, PreparedStatement stmt){
        try {
            if (stmt != null) {
                stmt.close();
            } 
        }catch (SQLException ex) {
            System.out.println("Execeção: "+ex);    
            
        }
        closeConnetion(con);
    }
    
    public static void closeConnetion(Connection con, PreparedStatement stmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            } 
        }catch (SQLException ex) {
            System.out.println("Execeção: "+ex);    
            
        }
        closeConnetion(con, stmt);
    }
}
