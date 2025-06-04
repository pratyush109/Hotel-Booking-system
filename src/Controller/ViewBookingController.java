/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import Model.BookingModel;
import Session.Session;
import View.MyBookingPanel;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ViewBookingController {
    
    private final BookingDao bookingDao;
    private final MyBookingPanel myBookingPanel;
    
  
    
    public ViewBookingController(MyBookingPanel myBookingPanel) {
        
        this.myBookingPanel = myBookingPanel;
        this.bookingDao = new BookingDao();
        
        LoadBookingInfo();
        
    }
    public void LoadBookingInfo() {
        
        int userId = Session.getSession().getLoggedInUserId();
        
        if(userId != -1) {
             List<BookingModel> bookingList = bookingDao.getBookingInfo();
             myBookingPanel.displayBookings(bookingList);
            
        }
        
    }
    
    
    
}
