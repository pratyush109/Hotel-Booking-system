/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import Model.BookingModel;
import View.BookRoomPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class BookingController {
    
    private final BookingDao bookingDao = new BookingDao();
    private final BookRoomPanel bookRoom;
 
   public BookingController(BookRoomPanel bookRoom) {
    this.bookRoom = bookRoom;

 
    bookRoom.addAddBookingListener(new AddBookingListener());
}
class AddBookingListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Button is clicked ");
        String roomType = bookRoom.getRoomType();
        int no_of_guest = bookRoom.getNoOfGuest();
        String check_out_date = bookRoom.getCheckOutDate();
        String check_in_date = bookRoom.getCheckInDate();
        int room_id = bookRoom.getRoomId();
        
       
        BookingModel booking = new BookingModel(room_id, roomType, no_of_guest, check_in_date, check_out_date);

        boolean isBooked = bookingDao.bookRoom(booking);

        if (isBooked) {
            JOptionPane.showMessageDialog(null, "Room booked successfully!");

        } else {
            JOptionPane.showMessageDialog(null, "Failed to book room.");
        }
    }
}

}
    

