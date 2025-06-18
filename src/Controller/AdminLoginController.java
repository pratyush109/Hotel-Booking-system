/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AuthDao;
import DAO.BookingDao;
import Model.AdminModel;
import View.AdminDashboard;
import View.AdminLogin;
import View.AdminViewBookingPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AdminLoginController {
    
    private final AdminLogin adminLogin;
    private final AuthDao adminLoginDao = new AuthDao();
    
    public AdminLoginController(AdminLogin adminLogin) {
        this.adminLogin = adminLogin;
        adminLogin.addAdminLoginListener(new AdminLoginListener());
    
    }
    public void open() {
            this.adminLogin.setVisible(true);
    }
    public void close() {
        this.adminLogin.dispose();
    } 
    
    class AdminLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String adminID = adminLogin.getUsername();
            String password = adminLogin.getPassword();
            
            AdminModel admin = new AdminModel(adminID, password);
           
            
            boolean success = adminLoginDao.AdminLogin(admin);
            
            if(success) {
                JOptionPane.showMessageDialog(adminLogin, "Login successful !");
                AdminDashboard adminDashboard = new AdminDashboard();
                adminDashboard.setVisible(true);
                adminLogin.dispose();
                
                BookingDao bookingDao = new BookingDao();
                AdminViewBookingPanel view = new AdminViewBookingPanel();
                BookingSearchController controller = new BookingSearchController(view);
                view.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(adminLogin, "Invalid username or password !");

            
            }
        } 
        
    }
   
    
    
}
