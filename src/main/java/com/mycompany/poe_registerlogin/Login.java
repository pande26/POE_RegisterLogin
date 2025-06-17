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

    public boolean checkUsername(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {
        return password != null && password.length() >= 8 &&
               password.matches(".*[A-Z].*") && 
               password.matches(".*\\d.*") && 
               password.matches(".*[!@#$%^&*()].*");
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}