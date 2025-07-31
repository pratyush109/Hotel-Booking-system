/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import View.ExpandedMyBookingPanel;
import Model.BookingModel;
import View.UserNavBar;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ViewExpandedBookingController {
    private final BookingDao bookingDao;
    private final ExpandedMyBookingPanel expandedBookingPanel;
    private final UserNavBar userDashboard;

    
    public ViewExpandedBookingController(ExpandedMyBookingPanel expandedBookingPanel, UserNavBar userDashboard) {
        this.expandedBookingPanel = expandedBookingPanel;
        this.userDashboard = userDashboard;
        this.bookingDao = new BookingDao();
       
    }
    
    public void detailedBookingInfo(int bookingId) {
        BookingModel detailedBooking = bookingDao.detailedBookingInfo(bookingId);
        
        if(detailedBooking != null) {
            userDashboard.showExpandedBookingPanel(detailedBooking);
            EditBookingController editBookingController = new EditBookingController(userDashboard.getExpandedMyBookingPanel(), detailedBooking);
             editBookingController.open(); 
        } else {
            JOptionPane.showMessageDialog( userDashboard, "Unable to load booking details");
        }
    }
    
}
