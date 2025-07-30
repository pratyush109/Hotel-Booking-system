/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontroller;

import DAO.BookingDao;
import Model.BookingModel;
import View.AdminViewBookingPanel;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ShowInTableController {
    
    private final BookingDao bookingDao = new BookingDao();
    private final AdminViewBookingPanel adminViewBooking;
    
    public ShowInTableController(AdminViewBookingPanel adminViewBooking) {
        this.adminViewBooking = adminViewBooking; 
    }
    
    public void loadBookingIntoTable() {
        
    List<BookingModel> bookings = bookingDao.getAllBookingsWithCustomerName();  

    var model = (javax.swing.table.DefaultTableModel) adminViewBooking.getMyTable().getModel();
    model.setRowCount(0);

    for (var b : bookings) {
        model.addRow(new Object[]{
            b.getCustomerName(),
            b.getRoomId(),
            b.getCheckInDate(),
            b.getCheckOutDate(),
            b.getStatus()
        });
    }
}

 }
    
