/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author DELL
 */


import DAO.LoginDao;
import Model.loginrequest;
import View.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logincontroller {
    private final LoginDao loginDao = new LoginDao();
    private final login loginView;

    public Logincontroller(login loginView) {
        this.loginView = loginView;
        this.loginView.addLoginListener(new LoginButtonListener());
    }

    public void open() {
        loginView.setVisible(true);
    }

    public void close() {
        loginView.dispose();
    }

    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            loginrequest loginReq = new loginrequest(username, password);

            boolean isValidUser = loginDao.authenticateUser(loginReq);

            if (isValidUser) {
                JOptionPane.showMessageDialog(loginView, "Login successful!");
                close(); // close login window or proceed further
            } else {
                JOptionPane.showMessageDialog(loginView, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

