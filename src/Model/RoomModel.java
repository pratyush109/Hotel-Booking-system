/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class RoomModel {
    
    private int room_id;
    private String roomType;
    private int no_of_guest;
    private int price;
    
    public RoomModel(String roomType, int no_of_guest, int price) {
       this.roomType = roomType ;
       this.no_of_guest = no_of_guest ;
       this.price = price;
    }

    
    public RoomModel(int room_id, String roomType, int no_of_guest, int price) {
       this.roomType = roomType ;
       this.no_of_guest = no_of_guest ;
       this.room_id = room_id;
       this.price = price;
    }
    
   //getter and setter for room type
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    //getter and setter for number of guest
      public int getNoOfGuest() {
        return no_of_guest;
    }
    public void setNoOfGuest(int no_of_guest) {
        this.no_of_guest = no_of_guest;
    }
    
    //getter and setter for room id
    public int getRoomId() {
        return room_id;
    }
    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }
    
    //getter and setter for price
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
 
 
}
