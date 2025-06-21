/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import DAO.InvoiceDao;
import Model.BookingModel;
import Model.ChargesCalculationModel;
import Model.InvoiceModel;
import View.PaymentPage;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class PaymentController {
    
    private final BookingDao bookingDao = new BookingDao();
    private final InvoiceDao invoiceDao = new InvoiceDao();
    private final PaymentPage paymentPage;
    
    public PaymentController(PaymentPage paymentPage) {
        this.paymentPage = paymentPage;
    }
    
//    public void processPayment(int bookingId, int roomId, int userId, double roomCharges, double serviceCharges, String paymentMethod) {
//    double tax = (roomCharges + serviceCharges) * 0.18; 
//    double total = roomCharges + serviceCharges + tax;
//    java.sql.Date invoiceDate = new java.sql.Date(System.currentTimeMillis());
//
//    boolean updated = bookingDao.updateStatusToPaid(bookingId); 
//
//    if (updated) {
//        invoiceDao.insertInvoice(new InvoiceModel(
//                
//        )); 
//
//        JOptionPane.showMessageDialog(null, "Payment successful! Invoice generated."); 
//    } else {
//        JOptionPane.showMessageDialog(null, "Payment failed. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
//    }
//}
    public void afterPayment(int bookingId, String paymentMethod) {
       
        boolean success = bookingDao.updateStatusToPaid(bookingId);

        
        if(success) {
            JOptionPane.showMessageDialog(paymentPage, "Payment successful! Status updated to 'Paid and booked'.");
            paymentPage.dispose();
            
            BookingModel bookingModel = bookingDao.detailedBookingInfo(bookingId);
            
            InvoiceModel invoice = new InvoiceModel();
            ChargesCalculationModel calculator = new ChargesCalculationModel();
            
            String roomType = bookingModel.getRoomType();
            double roomCharges = bookingModel.getPrice();
            double serviceCharges = calculator.calculateServiceCharge(roomType, roomCharges);
            
            invoice.setBooking_id(bookingModel.getBookingId());
            invoice.setRoomId(bookingModel.getRoomId());
            invoice.setInvoiceDate(LocalDate.now().toString());
            invoice.setCheckInDate(bookingModel.getCheckInDate());
            invoice.setCheckOutDate(bookingModel.getCheckOutDate());
            invoice.setRoomPrice(bookingModel.getPrice());
            invoice.setServiceCharge(serviceCharges);
            invoice.setTax(calculateTax());                            
            invoice.setTotalAmount(invoice.getRoomPrice() + invoice.getServiceCharge() + invoice.getTax());
            invoice.setPaymentMethod(paymentMethod);   
            
            
            
            

        }
        else {
            JOptionPane.showMessageDialog(paymentPage, "Payment failed. Please try again.");

        }
        
    }

    
}
