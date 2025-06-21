
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import View.registerform;
import DAO.userdao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
class AddUserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String fullName = register.getFullNameField().getText();
            String email = register.getEmailField().getText();
            String username = register.getUsernameField().getText();
            String password = register.getPasswordField().getText();
            String confirmPassword = register.getConfirmPasswordField().getText();
            String securityAnswer = register.getSecurityAnswerField().getText();

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(register, "Passwords do not match!");
                return;
            }

            RegistrationModel user = new RegistrationModel(fullName, email, username, password, confirmPassword);
            user.setSecurityAnswer(securityAnswer);

            if (userDao.checkRegistrationpagedata(user)) {
                JOptionPane.showMessageDialog(register, "Duplicate user");
            } else {
                userDao.register(user);
                JOptionPane.showMessageDialog(register, "User registered successfully!");
                close(); // optionally close form
            }

        } catch (Exception ex) {
            System.out.println("Error adding user: " + ex.getMessage());
            JOptionPane.showMessageDialog(register, "Error: " + ex.getMessage());
        }
    }
}
