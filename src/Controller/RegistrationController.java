/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.*;
import DAO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Userdata;

/**
 *
 * @author Dell
 */
public class RegistrationController {
    
    private final UserDao userdao = new UserDao();
    private final Register register;
    
    public RegistrationController(Register register) {
        this.register = register;
        
        register.addAddUserListener(new AddUserListener());
    }
    public void open() {
        this.register.setVisible(true);
        
    }
    public void close() {
        this.register.dispose();
    }
   

class AddUserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String fullname = register.getfullName().getText();
            String email = register.getEmailField().getText();
            String password = new String(register.getPasswordField().getPassword()); 
            String cpassword = new String(register.getCPasswordField().getPassword());
            String securityAnswer = register.getSecurityQuestion().getText();
            String username = register.getUsernameField().getText();
            Userdata user = new Userdata(fullname, email,username,password, securityAnswer);
            boolean check = userdao.checkUser(user);

           
            if (check) {
                JOptionPane.showMessageDialog(register, "Duplicate user");
                
            } else {
                userdao.register(user);
                JOptionPane.showMessageDialog(register, "Successfully Registered ! ");

            }

        
        
        } catch (Exception ex) {
            System.out.println("Error adding user: " + ex.getMessage());
            JOptionPane.showMessageDialog(register, "Registration failed: " + ex.getMessage());
        }
    }
 }
}
