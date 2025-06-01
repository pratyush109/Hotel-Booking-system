/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import Model.LoginModel;
import Session.Session;
import View.BookRoomPanel;
import View.UserDashboard;
import View.UserLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class LoginController {
    
    private final UserDao loginAuth = new UserDao();
    private final UserLogin userLogin;
    private int loggedInUserId = -1;
    
    public LoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
        
        userLogin.addLoginListener(new LoginListener());
    }
    public void open() {
        this.userLogin.setVisible(true);
    }
    public void close() {
        this.userLogin.dispose();
    }
    public int getLoggedInUserid() {
        return loggedInUserId;
    }
    
    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String username = userLogin.getUsername();
            String password = userLogin.getPassword();

            LoginModel user = new LoginModel();
            user.setUsername(username);
            user.setPassword(password);
            
            int userId = loginAuth.login(user);
            if(userId != -1) {
                Session.getSession().setLoggedInUserId(userId);
                
               JOptionPane.showMessageDialog(userLogin, "Login successful!");
               close();
               
               UserDashboard userDashboard = new UserDashboard();
               userDashboard.setVisible(true);
               
               BookRoomPanel bookRoomPanel = new BookRoomPanel();
               BookingController controller = new BookingController(bookRoomPanel);
               
            } else {
               JOptionPane.showMessageDialog(userLogin, "Invalid username or password");

                
            }
        }
    }
}
