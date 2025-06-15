/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.mysqlconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Registrationpagedata;
/**
 *
 * @author renisa
 */
public class userdao {
      mysqlconnection mysql = new mysqlconnection();
 
    public boolean Register(Registrationpagedata user) {
        Connection conn = mysql.openConnection();

 
      
 
        String sql = "INSERT INTO users (full_name, email, username, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getEmailAddress());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
 
          
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
 
    public boolean checkUser(Registrationpagedata user) {
        Connection conn = mysql.openConnection();
 
        String sql = "SELECT * FROM users WHERE email = ? OR username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getEmailAddress());
            pstmt.setString(2, user.getUsername());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public boolean checkUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
