/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.booking.management;

import Database.Database;
import Database.MySqlConnection;
import View.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Dell
 */
public class HotelBookingManagement {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
    try {
        UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (Exception ex) {
        System.err.println("Failed to initialize dark theme.");
    }

    Database db = new MySqlConnection();
    if (db.openConnection() != null) {
        System.out.println("Database connection successful");
    } else {
        System.out.println("Database connection failed");
    }

    SwingUtilities.invokeLater(() -> {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.setVisible(true);
        });
    }
}
