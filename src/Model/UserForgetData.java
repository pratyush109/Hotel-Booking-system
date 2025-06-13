 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pratyush
 */
public class UserForgetData {
    private String confirmpassword;
    private String email;
    private String newpassword;
    private String securityanswer;
    
    
    public UserForgetData(String confirmpassword,String email,String newpassword,String securityanswer){
        this.confirmpassword=confirmpassword;
        this.email=email;
        this.newpassword=newpassword;
        this.securityanswer=securityanswer;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
        
    }
    public String getNewPassword(){
     return newpassword;   
    }
    public void setNewPassword(String newpassword){
          this.newpassword=newpassword;   
    }
    public String getConfirmPassword(){
     return confirmpassword;   
    }
    public void setConfirmPassword(String confirmpassword){
        this.confirmpassword=confirmpassword;
    }
    public String getSecurityAnswer(){
     return securityanswer;   
    }
    public void setSecurityAnswer(String securityanswer){
        this.securityanswer=securityanswer;
    }
}

