/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UserProfileDao;
import Model.Userdata;
import Session.Session;

import View.MyProfilePanel;

import View.EditProfile;

import javax.swing.JOptionPane;


/**
 *

 * @author Dell
 */
public class UserProfileController {
    private final UserProfileDao userProfileDao;
    private final MyProfilePanel profilePanel;
    
 
    public UserProfileController(MyProfilePanel profilePanel) {

 * @author renisa
 */
public class UserProfileController {
    private final UserProfileDao userProfileDao;
    private final EditProfile profilePanel;
    
 
    public UserProfileController(EditProfile profilePanel) {

        this.profilePanel = profilePanel;
        this.userProfileDao = new UserProfileDao();
        
    }
    
    public void loadUserProfile() {
        int userId = Session.getSession().getLoggedInUserId();
       
        if(userId != -1) {
            Userdata user = userProfileDao.getUserProfile(userId);
            profilePanel.setEmail(user.getEmail());
            profilePanel.setFullName(user.getfullName());
            profilePanel.setUsername(user.getUsername());
            
        } else {
            JOptionPane.showMessageDialog(profilePanel, "User profile not found.");
        }
    }
    
    public void deleteUserProfile() {
        int userId = Session.getSession().getLoggedInUserId();
        
        if(userId == -1) {
            System.out.println("No user is logged in. ");
            return;
        }
        
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
        profilePanel,
                "Are you sure you want to delete your profile ?",
                "Confirm delete",
                javax.swing.JOptionPane.YES_NO_OPTION
        );
        
        if(confirm == javax.swing.JOptionPane.YES_OPTION) {
            boolean success = userProfileDao.deleteUserProfile(userId);
        } else {
            javax.swing.JOptionPane.showMessageDialog(profilePanel, "Failed to delete profile.");
        }
       
    }
    
    public void updateUserProfile() {
        
        String email = profilePanel.getEmail();
        String fullname = profilePanel.getFullName();
        String username = profilePanel.getUsername();
        
        Userdata updatedUser = new Userdata();
        updatedUser.setEmail(email);
        updatedUser.setfullName(fullname);
        updatedUser.setUsername(username);
        
        int userId = Session.getSession().getLoggedInUserId();
        
        boolean success = userProfileDao.updateUserProfile(updatedUser, userId);
        
        if(success) {
            JOptionPane.showMessageDialog(profilePanel, "Profile updated successfully");
        } else {
            JOptionPane.showMessageDialog(profilePanel, "Failed to update profile");

        }
    }
    
    
}
