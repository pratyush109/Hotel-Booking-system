/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

/**
 *
 * @author Dell
 */
public class Session { // A singleton design
    
    private static Session session;
    private int loggedInUserId = -1;
    private int bookingId = -1;
    //
    private Session() {} // private constructor will help us to prevent outside instantiation

    public static Session getSession() {
        if(session == null) {
            session = new Session();
        }
        return session;
    }
    // getter and setter for userId
    public int getLoggedInUserId() {
    return loggedInUserId;
    }
    public void setLoggedInUserId(int userId) {
        this.loggedInUserId = userId;
    }
    
    // getter and setter for bookingId
       public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int id) {
        this.bookingId = id;
    }
    
    
}
