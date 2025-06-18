/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BookingDao;
import Model.BookingModel;
import View.ExpandedMyBookingPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class EditBookingController {
    private final ExpandedMyBookingPanel expandedMyBookingPanel;
    private final BookingDao bookingDao = new BookingDao();
    private final BookingModel bookingModel;

    private boolean isEditMode = false;
    
    private String originalRoomType;
    private int originalGuestCount;
    private String originalCheckIn;
    private String originalCheckOut;
    private int originalRoomId;
    
    public EditBookingController(ExpandedMyBookingPanel expandedMyBookingPanel, BookingModel bookingModel) {
        this.expandedMyBookingPanel = expandedMyBookingPanel;
        this.bookingModel = bookingModel;

        expandedMyBookingPanel.addEditBookingListener(new EditBookingListener());
    }
    
    public void open() {
        this.expandedMyBookingPanel.setVisible(true);
    }
    
    class EditBookingListener implements ActionListener {
        
        private boolean isEditMode = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isEditMode) {
                enableEditMode();
            } else {
                saveChanges();
            }
        }

        private void enableEditMode() {
            expandedMyBookingPanel.getRoomTypeComboBox().setEnabled(true);
            expandedMyBookingPanel.getGuestSpinner().setEnabled(true);
            expandedMyBookingPanel.getCheckInDateCalendar().setEnabled(true);
            expandedMyBookingPanel.getCheckOutDateCalendar().setEnabled(true);
         

            expandedMyBookingPanel.getEditBookingButton().setText("Save Changes");
            isEditMode = true;
            
            storeOriginalValues();
        }

        private void saveChanges() {
            try {
                
                String roomType = expandedMyBookingPanel.getRoomTypeComboBox().getSelectedItem().toString();
                int guestCount = Integer.parseInt(expandedMyBookingPanel.getGuestSpinner().getValue().toString());
                
                Date checkInDate = expandedMyBookingPanel.getCheckInDateCalendar().getDate();
                Date checkOutDate = expandedMyBookingPanel.getCheckOutDateCalendar().getDate();
                
                String checkIn = new java.sql.Date(checkInDate.getTime()).toString();
                String checkOut = new java.sql.Date(checkOutDate.getTime()).toString();
                
                int currentBookingId = getCurrentBookingId();
                
                if (!validateInputs(checkInDate, checkOutDate, guestCount)) {
                    return; 
                }
                
                List<Integer> availableRooms = bookingDao.getAvailableRooms(roomType, guestCount, checkIn, checkOut, currentBookingId);

                if (availableRooms.isEmpty()) {
                    JOptionPane.showMessageDialog(expandedMyBookingPanel, "No rooms available for the selected criteria.");
                    return; 
                }

                String[] roomOptions = availableRooms.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new);
                    
                String selectedRoom = (String) JOptionPane.showInputDialog(
                    expandedMyBookingPanel,
                    "Select a room:",
                    "Available Rooms",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    roomOptions,
                    roomOptions[0]);
                    
                if (selectedRoom != null) {
                    int selectedRoomId = Integer.parseInt(selectedRoom);
                    
                    // Get the price from database based on room type
                    double totalAmount = getRoomPriceByType(roomType);
                    
                    if (updateBookingInDatabase(selectedRoomId, roomType, guestCount, checkIn, checkOut, totalAmount)) {
                        updateUIWithNewValues(selectedRoomId, roomType, guestCount, checkIn, checkOut);
                        JOptionPane.showMessageDialog(expandedMyBookingPanel, "Booking updated successfully!");
                        
                        disableEditMode();
                        refreshBookingDisplay();
                    } else {
                        JOptionPane.showMessageDialog(expandedMyBookingPanel, "Failed to update booking. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(expandedMyBookingPanel, "Room selection cancelled.");
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Please enter valid numbers.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private boolean validateInputs(Date checkInDate, Date checkOutDate, int guestCount) {
            if (checkInDate == null || checkOutDate == null) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Please select both check-in and check-out dates.");
                return false;
            }
            
            if (checkOutDate.before(checkInDate) || checkOutDate.equals(checkInDate)) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Check-out date must be after check-in date.");
                return false;
            }
            
            if (guestCount <= 0) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Guest count must be greater than 0.");
                return false;
            }
            
            Date today = new Date();
            if (checkInDate.before(today)) {
                JOptionPane.showMessageDialog(expandedMyBookingPanel, "Check-in date cannot be in the past.");
                return false;
            }
            
            return true;
        }

        private void disableEditMode() {
            expandedMyBookingPanel.getRoomTypeComboBox().setEnabled(false);
            expandedMyBookingPanel.getGuestSpinner().setEnabled(false);
            expandedMyBookingPanel.getCheckInDateCalendar().setEnabled(false);
            expandedMyBookingPanel.getCheckOutDateCalendar().setEnabled(false);
            
            expandedMyBookingPanel.getEditBookingButton().setText("Edit Booking");
            isEditMode = false;
        }

     private void storeOriginalValues() {
    originalRoomType = expandedMyBookingPanel.getRoomTypeComboBox().getSelectedItem().toString();
    originalGuestCount = Integer.parseInt(expandedMyBookingPanel.getGuestSpinner().getValue().toString());
    
    // Handle null dates safely
    Date checkInDate = expandedMyBookingPanel.getCheckInDateCalendar().getDate();
    Date checkOutDate = expandedMyBookingPanel.getCheckOutDateCalendar().getDate();
    
    if (checkInDate != null) {
        originalCheckIn = new java.sql.Date(checkInDate.getTime()).toString();
    } else {
        // Get the date from the text field instead
        originalCheckIn = expandedMyBookingPanel.getCheckInDate();
    }
    
    if (checkOutDate != null) {
        originalCheckOut = new java.sql.Date(checkOutDate.getTime()).toString();
    } else {
        // Get the date from the text field instead
        originalCheckOut = expandedMyBookingPanel.getCheckOutDate();
    }
    
    originalRoomId = getCurrentBookingRoomId();
}

        private boolean updateBookingInDatabase(int selectedRoomId, String roomType, int guestCount, String checkIn, String checkOut, double totalAmount) {
            try {
                int bookingId = getCurrentBookingId();
                
                // Use your existing DAO method
                boolean success = bookingDao.updateBooking(bookingId, selectedRoomId, roomType, guestCount, checkIn, checkOut);
                
                if (success) {
                    System.out.println("Booking updated successfully in database");
                } else {
                    System.err.println("Failed to update booking in database");
                }
                
                return success;
                
            } catch (Exception e) {
                System.err.println("Error updating booking: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

        private int getCurrentBookingId() {
            return bookingModel.getBookingId();
        }
        
        private int getCurrentBookingRoomId() {
            return bookingModel.getRoomId();
        }
        
        private double getRoomPriceByType(String roomType) {
            // This method should get price from database based on room type
            // Since this method is not in your DAO, I'll add it here but you should add it to your DAO
            return bookingDao.getRoomPriceByType(roomType);
        }

        private void updateUIWithNewValues(int roomId, String roomType, int guestCount, String checkIn, String checkOut) {
            bookingModel.setRoomId(roomId);
            bookingModel.setRoomType(roomType);
            bookingModel.setGuestCount(guestCount);
            bookingModel.setCheckInDate(checkIn);
            bookingModel.setCheckOutDate(checkOut);
            
            // Update price based on new room type
            double newPrice = getRoomPriceByType(roomType);
            bookingModel.setPrice((int) newPrice);
        }

        private void refreshBookingDisplay() {
            expandedMyBookingPanel.refreshDisplay(bookingModel);
        }
    }
}