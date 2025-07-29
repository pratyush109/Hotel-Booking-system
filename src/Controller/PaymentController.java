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
import View.Invoice;
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
    

public void afterPayment(int bookingId, String paymentMethod) {
    boolean success = bookingDao.updateStatusToPaid(bookingId);

    if(success) {
        JOptionPane.showMessageDialog(paymentPage, "Payment successful! Status updated to 'Paid and booked'.");

        BookingModel bookingModel = bookingDao.detailedBookingInfo(bookingId);

        InvoiceModel invoice = new InvoiceModel();

        String roomType = bookingModel.getRoomType();
        int roomCharges = bookingModel.getPrice();
        double serviceCharges = ChargesCalculationModel.calculateServiceCharge(roomType, roomCharges);
        double tax = ChargesCalculationModel.calculateTax(roomCharges, serviceCharges);

        invoice.setBooking_id(bookingModel.getBookingId());
        invoice.setRoomId(bookingModel.getRoomId());
        invoice.setInvoiceDate(LocalDate.now().toString());
        invoice.setCheckInDate(bookingModel.getCheckInDate());
        invoice.setCheckOutDate(bookingModel.getCheckOutDate());
        invoice.setRoomPrice(roomCharges);
        invoice.setServiceCharge(serviceCharges);
        invoice.setTax(tax);
        invoice.setTotalAmount(roomCharges + serviceCharges + tax);
        invoice.setPaymentMethod(paymentMethod);

        invoiceDao.addInvoice(invoice);
        
        Invoice invoiceUI = new Invoice(invoice);
        invoiceUI.setVisible(true);
        
        paymentPage.dispose();

        
       
        
        

    } else {
        JOptionPane.showMessageDialog(paymentPage, "Payment failed. Please try again.");
    }
}

    
}
