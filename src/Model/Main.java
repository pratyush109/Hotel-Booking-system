/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author renisa
 */
public class Main {
    public static void main(String[] args) {
        Registrationpagedata reg = new Registrationpagedata(
            "Alice Johnson",
            "alice@example.com",
            "alicej",
            "mypassword",
            "mypassword"
        );
 
        
        if (!reg.getPassword().equals(reg.getConfirmPassword())) {
            System.out.println("Error: Passwords do not match!");
        } else {
            System.out.println("Registration Successful!");
            System.out.println("Full Name: " + reg.getFullName());
            System.out.println("Email Address: " + reg.getEmailAddress());
            System.out.println("Username: " + reg.getUsername());
        }
    }
}

