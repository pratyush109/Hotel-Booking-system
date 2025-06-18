/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import Model.BookingModel;
import View.AdminViewBookingPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class BookingSearchController {
        
    private BookingDao bookingDao = new BookingDao();
    private AdminViewBookingPanel adminViewBookingPanel;
    
    public BookingSearchController(AdminViewBookingPanel adminViewBookingPanel) {
        
        this.adminViewBookingPanel = adminViewBookingPanel;
        
        adminViewBookingPanel.addSearchButton(e -> new SearchButton());
        
    }
    
    class SearchButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("clicked");
            String customerName = adminViewBookingPanel.getSearchField().getText().trim();
            String roomType = adminViewBookingPanel.getRoomTypeComboBox().getSelectedItem().toString().trim();
            
            String checkIn = getFormattedDate(adminViewBookingPanel.getCheckInChooser());
            String checkOut = getFormattedDate(adminViewBookingPanel.getCheckOutChooser());
            
            List<BookingModel> bookings = bookingDao.searchBookingsWithFilters(customerName, roomType, checkIn, checkOut);
            
            adminViewBookingPanel.displayBookings(bookings);
        }
            
            private String getFormattedDate(JDateChooser chooser) {
            Date date = chooser.getDate();
            if (date == null) return null;
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        
            
        }
        
    }   
    
}

