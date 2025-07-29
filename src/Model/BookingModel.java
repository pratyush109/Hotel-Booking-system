
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Session.Session;

/**
 *
 * @author Dell
 */
public class BookingModel {
  
    private int price;
    private int bookingId;
    private int userId;
    private int roomId;
    private String roomType;
    private int guestCount;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    private String customer_name;
    
    public BookingModel() {} // to create an empty object (used in getBookingInfo in BookingDao)
    
    // for table in admin view booking panel
    public BookingModel(String customer_name, int roomId, String checkInDate, String checkOutDate, String status) {
        this.customer_name = customer_name;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
   
    
    public BookingModel(int guestCount, String roomType, String checkInDate, String checkOutDate) {
    this.guestCount = guestCount;
    this.roomType = roomType;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    } //this constructor is used it updateBooking controller

     
    //this constructor is for booking room where booking id is not necessary to insert 
    public BookingModel(int roomId, String roomType, int guestCount, String checkInDate, String checkOutDate) {
    this.userId = Session.getSession().getLoggedInUserId();
    this.roomId = roomId;
    this.roomType = roomType;
    this.guestCount = guestCount;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
}

    // it for the case where booking id is necessary (displaying in UI)
    public BookingModel(int bookingId, int roomId, String roomType, int guestCount, String checkInDate, String checkOutDate, String status) {
        this.bookingId = bookingId;
        this.userId = Session.getSession().getLoggedInUserId();
        this.roomId = roomId;
        this.roomType = roomType;
        this.guestCount = guestCount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for roomId
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
     // Getter and Setter for roomType
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType= roomType;
    }
    
    //getter and setter for guestCount
    public int getGuestCount() {
        return guestCount;
    }
    public void setGuestCount(int guestCount) {
         this.guestCount = guestCount;
    }

    // Getter and Setter for checkInDate
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    // Getter and Setter for checkOutDate
    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
      // Getter and Setter for bookingId
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    
        // Getter and Setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // getter and setter for status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    // getter and setter for customer_name
    public String getCustomerName() {
        return customer_name;
    }
    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }
    
     


   
}

    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Session.Session;

/**
 *
 * @author Dell
 */
public class BookingModel {
  
    private int price;
    private int bookingId;
    private int userId;
    private int roomId;
    private String roomType;
    private int guestCount;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    private String customer_name;
    
    public BookingModel() {} // to create an empty object (used in getBookingInfo in BookingDao)
    
    // for table in admin view booking panel
    public BookingModel(String customer_name, int roomId, String checkInDate, String checkOutDate, String status) {
        this.customer_name = customer_name;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
   
    
    public BookingModel(int guestCount, String roomType, String checkInDate, String checkOutDate) {
    this.guestCount = guestCount;
    this.roomType = roomType;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    } //this constructor is used it updateBooking controller
// model
     
    //this constructor is for booking room where booking id is not necessary to insert 
    public BookingModel(int roomId, String roomType, int guestCount, String checkInDate, String checkOutDate) {
    this.userId = Session.getSession().getLoggedInUserId();
    this.roomId = roomId;
    this.roomType = roomType;
    this.guestCount = guestCount;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
}

    // it for the case where booking id is necessary (displaying in UI)
    public BookingModel(int bookingId, int roomId, String roomType, int guestCount, String checkInDate, String checkOutDate, String status) {
        this.bookingId = bookingId;
        this.userId = Session.getSession().getLoggedInUserId();
        this.roomId = roomId;
        this.roomType = roomType;
        this.guestCount = guestCount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for roomId
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
     // Getter and Setter for roomType
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType= roomType;
    }
    
    //getter and setter for guestCount
    public int getGuestCount() {
        return guestCount;
    }
    public void setGuestCount(int guestCount) {
         this.guestCount = guestCount;
    }

    // Getter and Setter for checkInDate
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    // Getter and Setter for checkOutDate
    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
      // Getter and Setter for bookingId
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    
        // Getter and Setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // getter and setter for status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    // getter and setter for customer_name
    public String getCustomerName() {
        return customer_name;
    }
    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }



   
}

    

