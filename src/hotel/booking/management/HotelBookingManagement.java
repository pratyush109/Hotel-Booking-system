/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.booking.management;

import Controller.RegistrationController;
import Database.Database;
import Database.MySqlConnection;
import View.Register;

/**
 *
 * @author Pratyush
 */
public class HotelBookingManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Database db = new MySqlConnection();
        if(db.openConnection() !=null) {
            System.out.println("Database connection successfull");
        } 
        else {
            System.out.println("Database connection failed");
        }
        
        Register registerform = new Register();
        RegistrationController controller = new RegistrationController(registerform);
        controller.open();
      
    }
    
}
