/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AddRoomDao;
import Model.RoomModel;
import View.AddRoom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AddRoomController {
    
    private final AddRoomDao addRoomDao = new AddRoomDao();
    private final AddRoom addRoom;
    
    public AddRoomController(AddRoom addRoom) {
        this.addRoom = addRoom;
        addRoom.addAddRoomListener(new AddRoomListener());
    }
    public void open() {
        addRoom.setVisible(true);
    }
 
    
    class AddRoomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String roomType = addRoom.getRoomType();
            int guests = addRoom.getGuests();
            int price = addRoom.getPrice();
            String imagePath = addRoom.getImagePath();
            
            if(imagePath == null || imagePath.trim().isEmpty()) {
                JOptionPane.showMessageDialog(addRoom, "Please select an image for the room");
                return;
            }
            
            RoomModel roomModel = new RoomModel(roomType,guests,price,imagePath);
            
            boolean success = addRoomDao.AddRoom(roomModel);
            
            if(success) {
            JOptionPane.showMessageDialog(addRoom, "Room added successfully");
            addRoom.clearImagePathField();

            } else {
            JOptionPane.showMessageDialog(addRoom, "Failed to add room");

            }
        }
        
        
    }
    
}
