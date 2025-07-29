/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.*;
import Model.BookingModel;
import Session.Session;
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
    
    // For booking room
    
    public boolean bookRoom(BookingModel bookingModel) {
    Connection conn = connection.openConnection();
// connection
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
    
    
    
 // To get the available room and display it on combo box

public List<Integer> getAvailableRooms(String roomType, int guestCount, String checkInDate, String checkOutDate, Integer excludeBookingId) {
    Connection conn = connection.openConnection();
    List<Integer> availableRooms = new ArrayList<>();
   
    String sql = "SELECT room_id FROM Rooms " +
                 "WHERE room_type = ? AND max_guests >= ? " +
                 "AND room_id NOT IN (" +
                 "SELECT room_id FROM Bookings " +
                 "WHERE check_in_date < ? AND check_out_date > ?";
    
    if (excludeBookingId != null) {
        sql += " AND booking_id != ?";
    }
    sql += ")";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, roomType);
        stmt.setInt(2, guestCount);
        stmt.setString(3, checkOutDate);
        stmt.setString(4, checkInDate);
        if (excludeBookingId != null) {
            stmt.setInt(5, excludeBookingId);
        }
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            availableRooms.add(rs.getInt("room_id"));
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    finally {
        connection.closeConnection(conn);
    }   
    return availableRooms;
}

// 
public List<BookingModel> getBookingInfo() {
    
    List<BookingModel> bookings = new ArrayList<>();

    Connection conn = connection.openConnection();
    
    String sql = "SELECT b.booking_id, r.room_type, b.check_in_date, b.guest_count, r.price FROM Bookings b JOIN Rooms r ON b.room_id = r.room_id WHERE b.user_id = ?";

     

    try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
        int userId = Session.getSession().getLoggedInUserId();
        pstmt.setInt(1, userId);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            
            BookingModel bookingModel = new BookingModel();
            
            bookingModel.setBookingId(rs.getInt("booking_id"));            
            bookingModel.setRoomType(rs.getString("room_type"));
            bookingModel.setCheckInDate(rs.getString("check_in_date"));
            bookingModel.setGuestCount(rs.getInt("guest_count"));
            bookingModel.setPrice(rs.getInt("price"));
            
            bookings.add(bookingModel);
        }
        
        
        
        
    } catch(SQLException e) {
        
        Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
        return null;
        
    
    } finally {
        connection.closeConnection(conn);
    }
    
    return bookings;

}
// For expanded booking panel (when user clicks on read more button in booking card  panel)

public BookingModel detailedBookingInfo(int bookingId) {
    Connection conn = connection.openConnection();
    
    BookingModel bookingModel = null;
    
    String sql = "SELECT b.booking_id, r.room_id, r.room_type, u.user_id, b.guest_count, check_in_date, check_out_date, price, status FROM Bookings b join Users u on u.user_id = b.user_id join Rooms r on r.room_id = b.room_id WHERE b.booking_id = ?";
    
    try(PreparedStatement ptsmt = conn.prepareStatement(sql) ) {
        ptsmt.setInt(1, bookingId);
        
        ResultSet rs = ptsmt.executeQuery();
        
        if(rs.next()) {
            bookingModel = new BookingModel();
            
            bookingModel.setBookingId(rs.getInt("booking_id"));
            bookingModel.setRoomType(rs.getString("room_type"));
            bookingModel.setRoomId(rs.getInt("room_id")); 
            bookingModel.setUserId(rs.getInt("user_id"));
            bookingModel.setGuestCount(rs.getInt("guest_count"));
            bookingModel.setCheckInDate(rs.getString("check_in_date"));
            bookingModel.setCheckOutDate(rs.getString("check_out_date"));
            bookingModel.setPrice(rs.getInt("price"));
            bookingModel.setStatus(rs.getString("status"));
              
        }
    } catch(SQLException e) {
        
        Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
        return null;
        
    
    } finally {
        connection.closeConnection(conn);
    }
    
    return bookingModel;
    
}

// after the payment 
    public boolean updateStatusToPaid(int bookingId) {
        Connection conn = connection.openConnection();
        
        String sql = "Update Bookings SET status = ? WHERE booking_id = ?";
        
        try(PreparedStatement ptsmt = conn.prepareStatement(sql)) {
            ptsmt.setString(1,"Paid and booked");
            ptsmt.setInt(2, bookingId);
            
            int rowsAffected = ptsmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch(SQLException e) {
         Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
         return false;
        
        } finally {
            connection.closeConnection(conn);
        }
         
    }
    
    
// Updated updateBooking method - WITHOUT total_amount
public boolean updateBooking(int bookingId, int roomId, String roomType, int guestCount, String checkIn, String checkOut) {
    Connection conn = connection.openConnection();
    
    try {
        if (!validateRoomType(roomId, roomType)) {
            throw new SQLException("Selected room does not match the specified room type");
        }
        
        // Remove total_amount from the UPDATE query
        String sql = "UPDATE bookings SET room_id = ?, guest_count = ?, check_in_date = ?, check_out_date = ? WHERE booking_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roomId);
            pstmt.setInt(2, guestCount);
            pstmt.setString(3, checkIn);
            pstmt.setString(4, checkOut);
            pstmt.setInt(5, bookingId); // bookingId is now parameter 5
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to update booking - no rows affected");
            }
            
            return true;
        }
        
    } catch (SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Update booking failed", e);
        return false;
        
    } finally {
        connection.closeConnection(conn);
    }
}

public boolean updateBookingPayment(int bookingId, double totalAmount, String paymentStatus) {
    Connection conn = connection.openConnection();
    
    try {
        String sql = "UPDATE bookings SET total_amount = ?, payment_status = ? WHERE booking_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, totalAmount);
            pstmt.setString(2, paymentStatus); 
            pstmt.setInt(3, bookingId);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to update booking payment - no rows affected");
            }
            
            return true;
        }
        
    } catch (SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Update booking payment failed", e);
        return false;
        
    } finally {
        connection.closeConnection(conn);
    }
}

public boolean updateBookingTotalAmount(int bookingId, double totalAmount) {
    Connection conn = connection.openConnection();
    
    try {
        String sql = "UPDATE bookings SET total_amount = ? WHERE booking_id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, totalAmount);
            pstmt.setInt(2, bookingId);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
        
    } catch (SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Update booking total amount failed", e);
        return false;
        
    } finally {
        connection.closeConnection(conn);
    }
}
 private boolean validateRoomType(int roomId, String expectedRoomType) {
    Connection conn = connection.openConnection();
    String sql = "SELECT room_type FROM rooms WHERE room_id = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, roomId);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String actualRoomType = rs.getString("room_type");
            return expectedRoomType.equals(actualRoomType);
        }
        
    } catch (SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Room type validation failed", e);
    } finally {
        connection.closeConnection(conn);
    }
    
    return false;
}
 public double getRoomPriceByType(String roomType) {
    Connection conn = connection.openConnection();
    String sql = "SELECT price FROM Rooms WHERE room_type = ? LIMIT 1";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, roomType);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            return rs.getDouble("price");
        }
        
    } catch (SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Failed to get room price", e);
    } finally {
        connection.closeConnection(conn);
    }
    
    return 0.0; 
 }
 // For bookig card panel
 public BookingModel getBookingById(String bookingId) {
     
    Connection conn = connection.openConnection();
    String sql = "SELECT * FROM bookings WHERE booking_id = ?";
    BookingModel booking = null;
    
    try ( PreparedStatement pstmt = conn.prepareStatement(sql)) 
    {
        
        pstmt.setInt(1, Integer.parseInt(bookingId));
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            booking = new BookingModel();
            booking.setBookingId(rs.getInt("booking_id"));
            booking.setRoomId(rs.getInt("room_id"));
            booking.setGuestCount(rs.getInt("guest_count"));
            booking.setCheckInDate(rs.getString("check_in_date"));
            booking.setCheckOutDate(rs.getString("check_out_date"));
        }
        
    } catch (SQLException e) {
        System.err.println("Error retrieving booking: " + e.getMessage());
        e.printStackTrace();
    }
    
    return booking;
}
 
 // For table
 public List<BookingModel> getAllBookingsWithCustomerName() {
     
     List<BookingModel> bookings = new ArrayList<>();
     
     Connection conn = connection.openConnection();
     String sql = "SELECT b.room_id, b.check_in_date, b.check_out_date, b.status, u.fullname "
             + "FROM bookings b join Users u on u.user_id = b.user_id";
     
     try(PreparedStatement ptsmt = conn.prepareStatement(sql)) {
         
         ResultSet rs = ptsmt.executeQuery();
         
         while(rs.next()) {
             BookingModel booking = new BookingModel();
             booking.setCustomerName(rs.getString("fullname"));
             booking.setRoomId(rs.getInt("room_id"));
             booking.setCheckInDate(rs.getString("check_in_date"));
             booking.setCheckOutDate(rs.getString("check_out_date"));
             booking.setStatus(rs.getString("status"));
             
             bookings.add(booking);

         }
      } catch(SQLException e) {
        
          Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Failed to fetch bookings with customer name", e);

      } finally {
         
        connection.closeConnection(conn);
        
     }
      return bookings;

 }
 
 // For search
 public List<BookingModel> searchBookingsWithFilters(String customerName, String roomType, String checkIn, String checkOut) {
 
     List<BookingModel> bookings = new ArrayList<>();
     
     Connection conn = connection.openConnection();
     
     //StringBuilder helps us write the query which keeps changing itself
     StringBuilder sql = new StringBuilder("SELECT u.fullname, r.room_id, b.check_in_date, b.check_out_date, b.status FROM Bookings b "
             + "JOIN Users u on u.user_id = b.user_id "
             + "JOIN Rooms r on r.room_id = b.room_id "
             + "WHERE 1 = 1" );
     List<Object> parameters = new ArrayList<>();
     
     if(customerName != null && !customerName.trim().isEmpty()) {
        sql.append(" AND LOWER(u.fullname) LIKE ?");
        parameters.add("%" + customerName.trim() + "%");
}
     if(roomType != null && !roomType.isEmpty()) {
         sql.append(" AND LOWER(r.room_type) = ?");
         parameters.add(roomType);
         
     }
        if (checkIn != null && !checkIn.isEmpty()) {
        sql.append(" AND b.check_in_date >= ?");
        parameters.add(checkIn);
    }

    if (checkOut != null && !checkOut.isEmpty()) {
        sql.append(" AND b.check_out_date <= ?");
        parameters.add(checkOut);
    }
     
     try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) { // because we have used StringBuilder
           for (int i = 0; i < parameters.size(); i++) {
            pstmt.setObject(i + 1, parameters.get(i));
        }
         
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next()) {
            BookingModel booking = new BookingModel();
            booking.setCustomerName(rs.getString("fullname"));
            booking.setRoomId(rs.getInt("room_id"));
            booking.setCheckInDate(rs.getString("check_in_date"));
            booking.setCheckOutDate(rs.getString("check_out_date"));
            booking.setStatus(rs.getString("status"));
            
            bookings.add(booking);
         }
     }

         catch(SQLException e) {
        Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, "Failed to fetch bookings with customer name", e);

      } finally {
         
        connection.closeConnection(conn);
        
     }
      return bookings;
                 }
          
 
}