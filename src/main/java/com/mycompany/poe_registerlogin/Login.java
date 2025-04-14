/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_registerlogin;

/**
 *
 * @author RC_Student_lab
 */
class Login {
    
       private String username;
       private String password;
       private String verifyUsername;
       private String verifyPassword;

       //getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getVerifyUsername() {
        return verifyUsername;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }
       
      //setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerifyUsername(String verifyUsername) {
        this.verifyUsername = verifyUsername;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    
       

    public boolean checkUsername(String username) {
        
         if(username.contains("_") && username.length() <=5) {
        return true; 
        }else{     
           return false;} 
        
    }    
            
    public boolean checkPassword(String password) {
        if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()_+{}<>?=/].*")) {
             return true;
             
        }else{
             return false;
        }
       
     }
    public boolean loginUser(String username, String password, String verifyUsername, String verifyPassword) {
    // Replace 'this.username' and 'this.password' with the actual stored values
    return this.username.equals(verifyUsername) && this.password.equals(verifyPassword);
}
    }


    

