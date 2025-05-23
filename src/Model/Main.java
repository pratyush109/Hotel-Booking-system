/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) {
       
        Forgetpassworddata resetRequest = new Forgetpassworddata(
            "alice@example.com",
            "newpassword123",
            "newpassword123",
            "Sunny"
        );

        if (!resetRequest.getNewPassword().equals(resetRequest.getConfirmPassword())) {
            System.out.println("Error: Passwords do not match!");
        } else {
            System.out.println("Password Reset Successful!");
            System.out.println("Email: " + resetRequest.getEmail());
            System.out.println("Security Answer: " + resetRequest.getSecurityAnswer());
        }
    }
}