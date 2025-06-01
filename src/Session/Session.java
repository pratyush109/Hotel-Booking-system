/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

/**
 *
 * @author Dell
 */
public class Session {
    private static Session session;
    private int loggedInUserId = -1;
    
    private Session() {}

    public static Session getSession() {
        if(session == null) {
            session = new Session();
        }
        return session;
    }
    public int getLoggedInUserId() {
    return loggedInUserId;
    }
    public void setLoggedInUserId(int userId) {
        this.loggedInUserId = userId;
    }
    
    
}
