/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class ChargesCalculationModel {
    
  public static double calculateServiceCharge(String roomType, double roomCharges) {
    
    roomType = "standard";   
    

    String Type = roomType.trim().toLowerCase();

    double rate;
    switch(Type) {
        case "deluxe":
            rate = 0.15;
            break;
        case "standard":
            rate = 0.10;
            break;
        case "super deluxe":
            rate = 0.25;  
            break;
        default:
            rate = 0.10;
    }
    return roomCharges * rate;
}

    
}
