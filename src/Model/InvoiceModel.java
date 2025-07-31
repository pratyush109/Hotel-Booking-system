/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class InvoiceModel {
  //  
    private int booking_id;   
    private int invoice_id;
    private String invoice_date;    
    private double tax;
    private double total_amount;
    private String status;
    private String payment_method;
    private int room_id;     
    private String checkInDate;    
    private String checkOutDate;
    private int room_price;
    private double serviceCharge;
    
    
    public InvoiceModel() {}

    
    

    public InvoiceModel(int booking_id, String invoice_date, double tax, double serviceCharge ,double total_amount,
                    String status, String payment_method, int room_id, String checkInDate,
                    String checkOutDate, int room_price) {
    this.booking_id = booking_id;
    this.invoice_date = invoice_date;
    this.tax = tax;
    this.total_amount = total_amount;
    this.status = status;
    this.payment_method = payment_method;
    this.room_id = room_id;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.room_price = room_price;
    this.serviceCharge = serviceCharge;
}
    
    //getters and setters
    
    //getter and setter for booking_id
    public int getBookingId() {
    return booking_id;
    }
   
    
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }
        //getter and setter for invoice_id

    public int getInvoiceId() {
        return invoice_id;
    }

    public void setInvoiceId(int invoice_id) {
        this.invoice_id = invoice_id;
    }
        //getter and setter for invoice_date


    public String getInvoiceDate() {
        return invoice_date;
    }

    public void setInvoiceDate(String invoice_date) {
        this.invoice_date = invoice_date;
    }
        //getter and setter for Tax


    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
        //getter and setter for total_amount

    public double getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(double total_amount) {
        this.total_amount = total_amount;
    }
    //getter and setter for Status

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //getter and setter for payment_method

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }
    //getter and setter for room_id

    public int getRoomId() {
        return room_id;
    }

    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }
    //getter and setter for checkInDate

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
        //getter and setter for checkOutDate

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    //getter and setter for room_price

    public int getRoomPrice() {
        return room_price;
    }

    public void setRoomPrice(int room_price) {
        this.room_price = room_price;
    }
    
    //getter and setter for serviceCharge
     public double getServiceCharge() {
        return serviceCharge;
    }
    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}

    
 


