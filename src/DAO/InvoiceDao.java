/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.MySqlConnection;
import Model.InvoiceModel;
import Session.Session;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/////
/**
 *
 * @author Dell
 */
public class InvoiceDao {
    MySqlConnection connection = new MySqlConnection();
    
   
    public void addInvoice(InvoiceModel invoiceModel) {
        Connection conn = connection.openConnection();
        String sql = "INSERT INTO Invoices(booking_id,room_id, invoice_date, tax, room_charges, service_charges, total_amount, payment_method) VALUES(?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, invoiceModel.getBookingId());
            pstmt.setInt(2, invoiceModel.getRoomId());
            pstmt.setString(3, invoiceModel.getInvoiceDate());
            pstmt.setDouble(4, invoiceModel.getTax());
            pstmt.setDouble(5, invoiceModel.getRoomPrice());
            pstmt.setDouble(6, invoiceModel.getServiceCharge());
            pstmt.setDouble(7, invoiceModel.getTotalAmount());
            pstmt.setString(8, invoiceModel.getPaymentMethod());
            
            pstmt.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection(conn);
        }
        
    }
    public InvoiceModel getInvoiceDetails(int invoiceId) {
        
        Connection conn = connection.openConnection();
        InvoiceModel invoiceModel = null;
        
        String sql = "SELECT * FROM Invoices where user_id = ?";
        
        try(PreparedStatement ptsmt = conn.prepareStatement(sql)) {
            int userId = Session.getSession().getLoggedInUserId();
            
            ptsmt.setInt(1, userId);
            
            
        } catch(SQLException e) {
             Logger.getLogger(AuthDao.class.getName()).log(Level.SEVERE, null, e);
        return null;
        
    
    } finally {
        connection.closeConnection(conn);
    }
        return invoiceModel;
        
    }
    
    
}
