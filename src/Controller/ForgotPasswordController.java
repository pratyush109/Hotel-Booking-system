/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AuthDao;
import View.ForgotPassword;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ForgotPasswordController {

    private final AuthDao user = new AuthDao();
    private final ForgotPassword forgotPasswordView;

      public ForgotPasswordController(ForgotPassword forgotPasswordView) {
            this.forgotPasswordView = forgotPasswordView;

             forgotPasswordView.addForgotPasswordListener(new ForgotPasswordListener());
             forgotPasswordView.addConfirmEmailListener(new ConfirmEmailListener());
      }
        
        public void open() {
          this.forgotPasswordView.setVisible(true);

      }
        public void close() {
          this.forgotPasswordView.dispose();
      }

class ForgotPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = forgotPasswordView.getEmail();
            String securityAnswer = forgotPasswordView.getSecurityAnswer();
            String newPassword = forgotPasswordView.getNewPassword();

            boolean isUpdated = user.updatePasswordBySecurityAnswer(email, securityAnswer, newPassword);

            if (isUpdated) {
                JOptionPane.showMessageDialog(forgotPasswordView, "Password updated successfully!");
                forgotPasswordView.dispose(); 
            } else {
                JOptionPane.showMessageDialog(forgotPasswordView, "Incorrect email or security answer. Try again.");
            }
        }
    }

    class ConfirmEmailListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = forgotPasswordView.getEmail();

            if (user.isEmailRegistered(email)) {
                JOptionPane.showMessageDialog(forgotPasswordView, "Email verified!");
            } else {
                JOptionPane.showMessageDialog(forgotPasswordView, "Email not found!");
            }
        }
    }
}
