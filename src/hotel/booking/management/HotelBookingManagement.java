/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.booking.management;

import View.login;
import controller.Logincontroller;

/**
 * @author Pratyush
 */
public class HotelBookingManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        login loginForm = new login(); // Your login JFrame class
        Logincontroller controller = new Logincontroller(loginForm); // FIXED LINE
        controller.open(); // Show the login window
    }
}
