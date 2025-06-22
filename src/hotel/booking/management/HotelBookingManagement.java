
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.booking.management;

import Database.Database;
import Database.Mysqlconnection;

/**
 *
 * @author Pratyush
 */
public class HotelBookingManagement {

    public static void main(String[] args) {
        // TODO code application logic here
        Database db =  new Mysqlconnection();
        if(db.openConnection()!=null) {
            System.out.println("Database connected successfully");
                  
                    }
        else {
            System.out.println("Failed to connect to database");
        }
    } 
}

package hotel.booking.management;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */




import Database.Database;
import Database.MySqlConnection;
import View.*;

/**
 *
 * @author Pratyush
 */
public class HotelBookingManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
        
        
      
    }
    
}

