/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import ontroller.LoginController;
import java.awt.event.ActionListener;


/**
 *
 * @author Dell
 */
public class AdminLogin extends javax.swing.JFrame {



    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
       

    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo_panel = new javax.swing.JPanel();
        logo_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        login_contents = new javax.swing.JPanel();
        userloginLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        login_button = new javax.swing.JButton();
        returnToUserLogin_textlabel = new javax.swing.JLabel();
        adminidText_label2 = new javax.swing.JLabel();
        showPassword_button = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setBackground(new java.awt.Color(48, 47, 47));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setResizable(false);

        logo_panel.setBackground(new java.awt.Color(48, 47, 47));
        logo_panel.setForeground(new java.awt.Color(255, 255, 255));
        logo_panel.setPreferredSize(new java.awt.Dimension(400, 600));

        logo_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/largerlogo_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("staff only");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Aura");

        javax.swing.GroupLayout logo_panelLayout = new javax.swing.GroupLayout(logo_panel);
        logo_panel.setLayout(logo_panelLayout);
        logo_panelLayout.setHorizontalGroup(
            logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_panelLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logo_panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logo_panelLayout.createSequentialGroup()
                        .addComponent(logo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logo_panelLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jLabel3)
                    .addContainerGap(107, Short.MAX_VALUE)))
        );
        logo_panelLayout.setVerticalGroup(
            logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_panelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2)
                .addGap(93, 93, 93)
                .addComponent(logo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(logo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logo_panelLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel3)
                    .addContainerGap(489, Short.MAX_VALUE)))
        );

        getContentPane().add(logo_panel, java.awt.BorderLayout.LINE_START);

        login_contents.setBackground(new java.awt.Color(72, 99, 127));
        login_contents.setPreferredSize(new java.awt.Dimension(400, 600));

        userloginLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userloginLabel.setForeground(new java.awt.Color(255, 255, 255));
        userloginLabel.setText("ADMIN LOGIN");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/database-user 2.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Admin ID");

        usernameField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        usernameField.setText("admin ID");
        usernameField.setPreferredSize(new java.awt.Dimension(515, 130));
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.setText("password");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        login_button.setBackground(new java.awt.Color(36, 108, 119));
        login_button.setForeground(java.awt.Color.white);
        login_button.setText("login");
        login_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        login_button.setFocusable(false);
        login_button.setPreferredSize(new java.awt.Dimension(380, 82));
        login_button.setRolloverEnabled(false);
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        returnToUserLogin_textlabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnToUserLogin_textlabel.setForeground(java.awt.Color.white);
        returnToUserLogin_textlabel.setText("<html><u>Return to User Login</u></html>");
        returnToUserLogin_textlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnToUserLogin_textlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnToUserLogin_textlabelMouseClicked(evt);
            }
        });

        adminidText_label2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        adminidText_label2.setForeground(new java.awt.Color(255, 255, 255));
        adminidText_label2.setText("Password");

        showPassword_button.setBackground(new java.awt.Color(48, 47, 47));
        showPassword_button.setForeground(new java.awt.Color(217, 217, 217));
        showPassword_button.setText("show password");
        showPassword_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout login_contentsLayout = new javax.swing.GroupLayout(login_contents);
        login_contents.setLayout(login_contentsLayout);
        login_contentsLayout.setHorizontalGroup(
            login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_contentsLayout.createSequentialGroup()
                .addGroup(login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(login_contentsLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addGroup(login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(adminidText_label2)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(login_contentsLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(showPassword_button))))
                    .addGroup(login_contentsLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(returnToUserLogin_textlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 204, Short.MAX_VALUE))
            .addGroup(login_contentsLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(login_contentsLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userloginLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        login_contentsLayout.setVerticalGroup(
            login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_contentsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userloginLabel)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(adminidText_label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(login_contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPassword_button))
                .addGap(48, 48, 48)
                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(returnToUserLogin_textlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(login_contents, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void usernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusGained
        // TODO add your handling code here:
        if(usernameField.getText().equals("admin ID")){
            usernameField.setText("");
        }
    }//GEN-LAST:event_usernameFieldFocusGained

    private void usernameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusLost
        // TODO add your handling code here:
        if(usernameField.getText().equals("")){
            usernameField.setText("admin ID");
        }
    }//GEN-LAST:event_usernameFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        // TODO add your handling code here:
        if(new String (passwordField.getPassword()).equals("password")) {
            passwordField.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        // TODO add your handling code here:
        if(new String (passwordField.getPassword()).equals("")) {
            passwordField.setText("password");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_login_buttonActionPerformed

    private void showPassword_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword_buttonActionPerformed
        // TODO add your handling code here:
        if(showPassword_button.isSelected()) {
            passwordField.setEchoChar((char)0);
        } 
        else {
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_showPassword_buttonActionPerformed

    private void returnToUserLogin_textlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnToUserLogin_textlabelMouseClicked
        // TODO add your handling code here:
        UserLogin loginform = new UserLogin();
        LoginController logcontroller = new LoginController(loginform);
        logcontroller.open();
        
        this.dispose();
     
    }//GEN-LAST:event_returnToUserLogin_textlabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminidText_label2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login_button;
    private javax.swing.JPanel login_contents;
    private javax.swing.JLabel logo_label;
    private javax.swing.JPanel logo_panel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel returnToUserLogin_textlabel;
    private javax.swing.JCheckBox showPassword_button;
    private javax.swing.JLabel userloginLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

public void addAdminLoginListener(ActionListener listener) {  
    login_button.addActionListener(listener);
}
    
public String getUsername() {
    return usernameField.getText();
    }
public String getPassword() {
    return passwordField.getText();
    }

}

