package Model;

public class Userdata {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String securityAnswer;
    private String username;
    
    public Userdata(){}

    public Userdata(String fullName, String email,String username, String password, String securityAnswer) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.securityAnswer = securityAnswer;
        this.username = username;
    }

    //getters and setter for fullname
    public String getfullName() {
        return fullName;
    }
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
       //getters and setter for email
    public String getEmail() {
        return email;
    }
     public void setEmail(String email) {
        this.email = email;
    }
    
    //getters and setters for username
     public String getUsername() {
        return username;
    }
      public void setUsername(String username) {
        this.username = username;
    }
   
     
    //getters and setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    //getters and setter for security answer
    public String getSecurityAnswer() {
        return securityAnswer;
    }
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
      //getters and setter for security answer
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



 
}
