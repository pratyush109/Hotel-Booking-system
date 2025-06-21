/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.database.*;
import Database.mysqlconnection;
import Model.Userdata;
import Session.Session;
import View.EditProfile;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author renisa
 */
public class UserProfileDao {
    
   mysqlconnection mysql =new mysqlconnection();
   
  int userId = Session.getSession().getLoggedInUserId();
   
public Userdata getUserProfile(int userId) {
    
        
        Connection conn =  mysql.openConnection();
        
        String sql ="SELECT email, username, fullname FROM Users where user_id = ?";
       try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
           
              pstmt.setInt(1, userId); 
              
              ResultSet rs = pstmt.executeQuery();
              
              if(rs.next()) {
                  
                  Userdata user = new Userdata();
                  
                  user.setEmail(rs.getString("email"));
                  user.setfullName(rs.getString("fullname"));
                  user.setUsername(rs.getString("username"));
                  
                  return user;
                     
              }

              
       }catch(SQLException ex){
           java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }finally{
           mysql.closeConnection(conn);
       }
       return null;
       
    }
    
public boolean deleteUserProfile(int userId) {
    
    Connection conn = mysql.openConnection();
    String sql = "DELETE FROM Users WHERE user_id = ?";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, userId);

        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; 

    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } finally {
        mysql.closeConnection(conn);
    }

    return false;
}

public boolean updateUserProfile(Userdata user, int userId) {
    Connection conn = mysql.openConnection();
    String sql = "UPDATE Users SET email = ?, fullname = ?, username = ? WHERE user_id = ?";
 
   
 
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, user.getEmail());
        pstmt.setString(2, user.getfullName());
        pstmt.setString(3, user.getUsername());
        pstmt.setInt(4, userId);
       

        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; 

    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } finally {
        mysql.closeConnection(conn);
    }

    return false;
}

}
    
