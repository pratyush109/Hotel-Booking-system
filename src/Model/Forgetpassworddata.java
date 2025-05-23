/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Forgetpassworddata {
    private String email;
    private String newPassword;
    private String confirmPassword;
    private String securityAnswer; // For "What was your childhood nickname?"
    
    // Constructors
    public Forgetpassworddata() {
    }
    
    public Forgetpassworddata(String email, String newPassword, String confirmPassword, String securityAnswer) {
        this.email = email;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.securityAnswer = securityAnswer;
    }
    
    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
}
