/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.mysqlconnection;
import Model.AdminModel;
import Model.Userdata;
import Model.LoginModel;
import View.AdminLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AuthDao {
    mysqlconnection connection = new mysqlconnection();
    
    public void register(Userdata user) {
        Connection conn = connection.openConnection();
        
        String sql = "INSERT INTO Users (fullname, email, username, password, security_answer) VALUES(?,?,?,?,?)";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getfullName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getSecurityAnswer());
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(conn);
        } 
        
    }
      public boolean checkUser(Userdata user) {
            Connection conn = connection.openConnection();
            String sql = "SELECT * FROM Users where email = ? or username = ?";
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getEmail());
                pstmt.setString(2, user.getUsername());
                ResultSet result = pstmt.executeQuery();
                return result.next();
            } catch (SQLException ex) {
                Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                connection.closeConnection(conn);
          }
            return false;
            
            
        }
      public int login(LoginModel user) {
          int user_Id = -1;
          Connection conn = connection.openConnection();
          String sql = "SELECT user_id FROM Users WHERE username = ? AND password = ?";
          
          try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());

            ResultSet result = pstmt.executeQuery();
            if(result.next()) {
                return result.getInt("user_id");
            }
           
          
        } catch(SQLException ex) {
              Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, ex);
              return -1;
        } finally {
                connection.closeConnection(conn);
            }
          return user_Id;
     
    }
      public Userdata getSecutityAnswerAndUsername(String username) {
            Connection conn = connection.openConnection();
            String sql = "SELECT username , security_answer FROM Users WHERE username = ?";
            
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                Userdata user = new Userdata();
                user.setUsername(rs.getString("username"));
                user.setSecurityAnswer(rs.getString("security_answer"));
                return user;
            }
            } catch(SQLException ex) {
                Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, ex);
                
            } finally {
            connection.closeConnection(conn);
            }
            return null;
      }
      
      public boolean updatePasswordBySecurityAnswer(String email, String securityAnswer, String newPassword) {
        try (Connection con = connection.openConnection()) {
            String sql = "UPDATE users SET password = ? WHERE email = ? AND security_answer = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            stmt.setString(3, securityAnswer);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
}
      public boolean isEmailRegistered(String email) {
        Connection conn = connection.openConnection();
        String sql = "SELECT 1 FROM users WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.closeConnection(conn);
        }
}

      public boolean AdminLogin(AdminModel admin) {
          
          AdminLogin adminLogin = new AdminLogin();
          
          Connection conn = connection.openConnection();
          String sql = "SELECT id FROM admin WHERE username = ? and password = ? ";
          
          try(PreparedStatement ptsmt = conn.prepareStatement(sql)) {
              
              ptsmt.setString(1, admin.getAdminName());
              ptsmt.setString(2, admin.getPassword());
              
              ResultSet result = ptsmt.executeQuery();
              
              return result.next();
          
          } catch(SQLException e) {
        Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
        return false;
          } finally {
          connection.closeConnection(conn);

          }
      }

      
     

}
    
    
