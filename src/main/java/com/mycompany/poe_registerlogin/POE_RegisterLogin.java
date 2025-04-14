/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_registerlogin;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class POE_RegisterLogin {
    
     // Define this as a class constant
     private static final Pattern SA_PHONE_PATTERN = Pattern.compile("^(\\+27|0)[0-9]{9}$");
     
     public static boolean isValidSouthAfricanNumber(String phoneNumber) {
         return SA_PHONE_PATTERN.matcher(phoneNumber).matches();
     }
     
    public static void main(String[] args) {
        
        //Creating an intstance to create a class
        Login objLogin = new Login();
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("=== Registration ===");
        
        // Flag to control the loop
        boolean isValidUsername = false;
       
       // While loop to keep asking for username until it's correctly formatted
        while (!isValidUsername) {
       // Prompting user to enter username 
       System.out.println("Please enter your username");
       
       //User enters the username
        
        objLogin.setUsername(input.nextLine());
       
       //Using ifelse statements to check the username
       if(objLogin.checkUsername(objLogin.getUsername()) ==true){
           //Displaying the results
          System.out.println("Thank you for the username");  
          isValidUsername = true;  // Exit the loop
       }else{  
           //Displaying the results       
          System.out.println("The username is incorrectly formated, try again");
        }    
        }
       
      boolean isValidPhoneNumber = false;
      
         // While loop to keep asking for phone number until it's correctly formatted
        while (!isValidPhoneNumber) {
        //Prompting the user to enter a phone number
        System.out.println("Enter your phone number");
        String phoneNumber = input.nextLine().trim();
        
        if (isValidSouthAfricanNumber(phoneNumber)) {
            System.out.println("\nCell phone number successfully captured");
            
            //Displaying the results
            String formattedNumberphone = phoneNumber;
            System.out.println("Formated number " + formattedNumberphone);
             isValidPhoneNumber = true;
        }else{
           //Displaying the results
            System.out.println("\nCell phone number incorrectly formated, please try again\n");
           }          
        }
       
        boolean validPassword = false;
         
        // While loop to keep asking for password until it's valid
        while (!validPassword) {
        //Prompting the user to enter a password
        System.out.println("Enter a password");
        
        objLogin.setPassword(input.nextLine());
        
        //Using if else statements to check the password
        if (objLogin.checkPassword (objLogin.getPassword()) == true) {
         
             //Displaying the results
             System.out.println("Password successfully captured");
         validPassword = true;  // Exit the loop
        }else{
            //Displaying the results
            System.out.println("The password is incorrectly formated, try again\n");}
        }   
      
         // Additional user information
            System.out.print("Enter your first name: ");
            String firstName = input.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = input.nextLine();
               
            
            // Login section
            System.out.println("\n== Login ===");
            boolean loggedIn = false;
            int attempts = 0;
            final int MAX_ATTEMPTS = 3;

            while (!loggedIn && attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your username:");
            String loginUsername = input.nextLine();
            objLogin.setVerifyUsername(loginUsername);
            
            System.out.println("Enter your password:");
            String loginPassword = input.nextLine();

            if (loginUsername.equals(objLogin.getUsername()) &&  objLogin.loginUser(objLogin.getUsername(), objLogin.getPassword(), loginUsername, loginPassword)) {
                System.out.println("Login successful! Welcome, " + firstName + " " + lastName);
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Login failed. Please check your username and password.");
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("You have " + (MAX_ATTEMPTS - attempts) + " attempts remaining.");
                } else {
                    System.out.println("Maximum login attempts reached. Please try again later.");
                }
            }
        }
    
        if (loggedIn) {
            // User is logged in - you can add your application logic here
            System.out.println("\nWelcome to the system!");
        }

        input.close();
    }
}
            
       
    
        

    
 


    