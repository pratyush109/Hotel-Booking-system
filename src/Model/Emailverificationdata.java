/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author acer
 */
public class Emailverificationdata {
    private String email;
    private boolean isVerified;
    // Constructors
    public Emailverificationdata() {
        this.isVerified = false;
    }
    public Emailverificationdata(String email) {
        this.email = email;
        this.isVerified = false;
    }
    // Getters and Setters
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public boolean isVerified() {
        return isVerified;
    }
 
    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
    
    

