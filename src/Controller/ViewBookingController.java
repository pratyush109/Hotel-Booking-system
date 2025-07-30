/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import Model.BookingModel;
import Session.Session;
import View.ExpandedMyBookingPanel;
import View.MyBookingPanel;
import View.UserNavBar;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ViewBookingController {
    
    private final BookingDao bookingDao;
    private final MyBookingPanel myBookingPanel;
    private final UserNavBar userDashboard;
    private final ExpandedMyBookingPanel expandedMyBookingPanel;
    
    public ViewBookingController(MyBookingPanel myBookingPanel,UserNavBar userDashboard, ExpandedMyBookingPanel expandedMyBookingPanel) {
  
        this.myBookingPanel = myBookingPanel;
        this.bookingDao = new BookingDao();
         this.userDashboard = userDashboard;
        this.expandedMyBookingPanel = expandedMyBookingPanel;
      
        LoadBookingInfo();
    }
    public void LoadBookingInfo() {
        int userId = Session.getSession().getLoggedInUserId();
        
        if(userId != -1) {
             List<BookingModel> bookingList = bookingDao.getBookingInfo();
             ViewExpandedBookingController expandedController = new ViewExpandedBookingController(expandedMyBookingPanel, userDashboard);
             myBookingPanel.displayBookings(bookingList, expandedController);
            
        }
        
    }  
    
}
