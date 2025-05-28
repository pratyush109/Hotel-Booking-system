/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author acer
 */


public class Main {

    public static void main(String[] args) {

        Emailverificationdata verification = new Emailverificationdata(

            "alice@example.com"

        );
 
        System.out.println("Verification Email Sent");

        System.out.println("A verification link has been sent to");

        System.out.println("your email address: " + verification.getEmail());

        System.out.println("Please check your inbox to verify your account.");

        // Simulate user clicking verification link

        verification.setVerified(true);

        if (verification.isVerified()) {

            System.out.println("\nStatus: Email successfully verified!");

        } else {

            System.out.println("\nStatus: Pending verification");

        }

    }

}
 

