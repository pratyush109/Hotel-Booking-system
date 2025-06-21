/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.RoomModel;
import Database.MySqlConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class AddRoomDao {
    MySqlConnection connection = new MySqlConnection();    
    
   
    
    public boolean AddRoom(RoomModel roomModel) {
        Connection conn = connection.openConnection();
        
        String sql = "INSERT INTO Rooms (room_type, max_guests, price) VALUES (?,?,?)";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, roomModel.getRoomType());
            pstmt.setInt(2, roomModel.getNoOfGuest());
            pstmt.setInt(3, roomModel.getPrice());
            
            pstmt.executeUpdate();
            return true;
        
        } catch(SQLException e) {
            Logger.getLogger(AddRoomDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            connection.closeConnection(conn);
        }
    }
    
}
