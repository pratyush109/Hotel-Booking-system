/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.*;
import Model.BookingModel;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class BookingDao {
    
    MySqlConnection connection = new MySqlConnection();
    
    public boolean bookRoom(BookingModel bookingModel) {
    Connection conn = connection.openConnection();
    
    String sql = "INSERT INTO Bookings (room_id, user_id, check_in_date, check_out_date, guest_count) VALUES (?,?,?,?,?)";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, bookingModel.getRoomId());
        pstmt.setInt(2, bookingModel.getUserId());
        pstmt.setString(3, bookingModel.getCheckInDate());
        pstmt.setString(4, bookingModel.getCheckOutDate());
        pstmt.setInt(5, bookingModel.getGuestCount());
        
        int rowsAffected = pstmt.executeUpdate();
        
        if(rowsAffected > 0 ) {
            JOptionPane.showMessageDialog(null, "Booking successfull");
            return true;
        } else {
             JOptionPane.showMessageDialog(null, "Booking failed");
            return false;
        
        }
        
    } catch(SQLException e) {
         Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
         return false;
    } finally {
         connection.closeConnection(conn);
    }
    
    }
    
    
    
 

public List<Integer> getAvailableRooms(String roomType, int guestCount, String checkInDate, String checkOutDate) {
    Connection conn = connection.openConnection();
    List<Integer> availableRooms = new ArrayList<>();

    String sql = "SELECT room_id FROM Rooms " +
                 "WHERE room_type = ? AND max_guests >= ? " +
                 "AND room_id NOT IN (" +
                 "SELECT room_id FROM Bookings " +
                 "WHERE check_in_date < ? AND check_out_date > ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, roomType);
        stmt.setInt(2, guestCount);
        stmt.setString(3, checkOutDate);
        stmt.setString(4, checkInDate);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            availableRooms.add(rs.getInt("room_id"));
        }

    } catch (SQLException ex) {
        System.out.println(ex);
        
    }
    finally {
    connection.closeConnection(conn);
    }   return availableRooms;

}

}

