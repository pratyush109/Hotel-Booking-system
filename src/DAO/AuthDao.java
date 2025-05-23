/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Registrationpagedata;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class AuthDao {
    
    private Connection conn;
    
    public AuthDao(Connection conn) {
        this.conn = conn;
    }
    
    public boolean register(Registrationpagedata user) {
        try {
            String query = "INSERT INTO Users (fullname, email, username, password, security_answer) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getSecurityAnswer());
            
            return stmt.executeUpdate() > 0;
               
        } 
        catch(SQLException e) { 
            System.out.println(e);
            return false;
        }
        
        
    }
    
}