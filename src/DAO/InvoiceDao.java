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

/**
 *
 * @author Dell
 */
public class InvoiceDao {
    MySqlConnection connection = new MySqlConnection();
    
   
    public void addInvoice(InvoiceModel invoiceModel) {
        Connection conn = connection.openConnection();
        String sql = "INSERT INTO Invoice(booking_id,room_id, invoice_date, tax, room_charges, service_charges, total_amount, payment_method) VALUES(?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, invoiceModel.) 
            
        }
        
    }
    public InvoiceModel getInvoiceDetails(int invoiceId) {
        
        Connection conn = connection.openConnection();
        InvoiceModel invoiceModel = null;
        
        String sql = "SELECT * FROM Invoice where user_id = ?";
        
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
