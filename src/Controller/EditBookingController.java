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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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
        expandedMyBookingPanel.addCancelBookingListener(new CancelBookingListener());
    }

    public void open() {
        this.expandedMyBookingPanel.setVisible(true);
    }

    class EditBookingListener implements ActionListener {
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

                List<Integer> availableRooms = bookingDao.getAvailableRooms(
                        roomType, guestCount, checkIn, checkOut, currentBookingId);

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
                    double totalAmount = getRoomPriceByType(roomType);

                    if (updateBookingInDatabase(selectedRoomId, roomType, guestCount, checkIn, checkOut, totalAmount)) {
                        updateUIWithNewValues(selectedRoomId, roomType, guestCount, checkIn, checkOut);
                        JOptionPane.showMessageDialog(expandedMyBookingPanel, "Booking updated successfully!");

                        disableEditMode();
                        refreshBookingDisplay();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(expandedMyBookingPanel, "Failed to update booking. Please try again.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(expandedMyBookingPanel, "Room selection cancelled.");
                    return;
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

            Date checkInDate = expandedMyBookingPanel.getCheckInDateCalendar().getDate();
            Date checkOutDate = expandedMyBookingPanel.getCheckOutDateCalendar().getDate();

            originalCheckIn = (checkInDate != null)
                    ? new java.sql.Date(checkInDate.getTime()).toString()
                    : expandedMyBookingPanel.getCheckInDate();

            originalCheckOut = (checkOutDate != null)
                    ? new java.sql.Date(checkOutDate.getTime()).toString()
                    : expandedMyBookingPanel.getCheckOutDate();

            originalRoomId = getCurrentBookingRoomId();
        }

        private boolean updateBookingInDatabase(int selectedRoomId, String roomType, int guestCount,
                                                String checkIn, String checkOut, double totalAmount) {
            try {
                int bookingId = getCurrentBookingId();
                boolean success = bookingDao.updateBooking(bookingId, selectedRoomId, roomType, guestCount, checkIn, checkOut);
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
            return bookingDao.getRoomPriceByType(roomType);
        }

        private void updateUIWithNewValues(int roomId, String roomType, int guestCount, String checkIn, String checkOut) {
            bookingModel.setRoomId(roomId);
            bookingModel.setRoomType(roomType);
            bookingModel.setGuestCount(guestCount);
            bookingModel.setCheckInDate(checkIn);
            bookingModel.setCheckOutDate(checkOut);
            bookingModel.setPrice((int) getRoomPriceByType(roomType));
        }

        private void refreshBookingDisplay() {
            expandedMyBookingPanel.refreshDisplay(bookingModel);
        }
    }

    class CancelBookingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(
                    expandedMyBookingPanel,
                    "Are you sure you want to cancel this booking?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = bookingDao.cancelBooking(bookingModel);
                if (success) {
                    JOptionPane.showMessageDialog(expandedMyBookingPanel, "Booking cancelled successfully!");
                    expandedMyBookingPanel.refreshDisplay(bookingModel);
                } else {
                    JOptionPane.showMessageDialog(expandedMyBookingPanel, "Failed to cancel booking.");
                }
            }
        }
    }
}
