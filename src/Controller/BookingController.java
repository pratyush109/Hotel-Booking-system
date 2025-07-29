
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

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

        String roomType = bookRoom.getRoomType();
        int no_of_guest = bookRoom.getNoOfGuest();
        String check_out_date = bookRoom.getCheckOutDate();
        String check_in_date = bookRoom.getCheckInDate();
        int room_id = bookRoom.getRoomId();
         try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkIn = LocalDate.parse(check_in_date, formatter);
        LocalDate checkOut = LocalDate.parse(check_out_date, formatter);

        if (!checkIn.isBefore(checkOut)) {
            JOptionPane.showMessageDialog(null, "Check-in date must be before check-out date.");
            return; 
        }
    } catch (DateTimeParseException ex) {
        JOptionPane.showMessageDialog(null, "Please enter valid dates in yyyy-MM-dd format.");
        return; 
    }
       
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
// controller
    private final BookingDao bookingDao = new BookingDao();
    private final BookRoomPanel bookRoom;
 
   public BookingController(BookRoomPanel bookRoom) {
    this.bookRoom = bookRoom;

 
    bookRoom.addAddBookingListener(new AddBookingListener());
}
class AddBookingListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

       
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

