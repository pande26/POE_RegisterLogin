/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_registerlogin;

/**
 *
 * @author RC_Student_lab
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class POE_RegisterLogin {
    
     // Define this as a class constant
     private static final Pattern SA_PHONE_PATTERN = Pattern.compile("^(\\+27|0)[0-9]{9}$");
     
     public static boolean isValidSouthAfricanNumber(String phoneNumber) {
         return SA_PHONE_PATTERN.matcher(phoneNumber).matches();
     }
    private static final ArrayList<Message> messages = new ArrayList<>();
    private static int totalMessagesSent = 0;
    private static final Scanner scanner = new Scanner(System.in);

     
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

        System.out.println("Welcome to QuickChat");
        runApplication();
    }
    private static void runApplication() {
        boolean running = true;
        
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (1-3)");
                continue;
            }

            switch (choice) {
                case 1 -> sendMessages();
                case 2 -> System.out.println("\nComing Soon.");
                case 3 -> {
                    running = false;
                    System.out.println("\nTotal messages sent: " + totalMessagesSent);
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please enter 1-3.");
            }
        }
    }

    private static void sendMessages() {
        System.out.print("\nHow many messages would you like to send? ");
        int messageCount;
        
        try {
            messageCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        for (int i = 0; i < messageCount; i++) {
            System.out.println("\nCreating message " + (i + 1) + " of " + messageCount);
            Message message = createMessage(i + 1);
            if (message != null) {
                messages.add(message);
                totalMessagesSent++;
                displayMessageDetails(message);
            }
        }
    }

    private static Message createMessage(int messageNumber) {
        System.out.print("Enter recipient's cell number (with international code): ");
        String recipient = scanner.nextLine();
        if (!Message.checkRecipientCell(recipient)) {
            System.out.println("Invalid recipient number. Must be 10 digits with international code.");
            return null;
        }

        System.out.print("Enter your message (max 250 characters): ");
        String content = scanner.nextLine();
        if (content.length() > 250) {
            System.out.println("Message too long. Must be 250 characters or less.");
            return null;
        }

        String messageId = generateMessageId();
        String messageHash = Message.createMessageHash(messageId, messageNumber, content);

        Message message = new Message(messageId, messageNumber, recipient, content, messageHash);

        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        System.out.print("Enter your choice: ");
        
        int action;
        try {
            action = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Message will be disregarded.");
            return null;
        }

        switch (action) {
            case 1 -> {
                return message;
            }
            case 2 -> {
                return null;
            }
            case 3 -> {
                message.storeMessage();
                System.out.println("Message stored successfully.");
                return null;
            }
            default -> {
                System.out.println("Invalid choice. Message will be disregarded.");
                return null;
            }
        }
    }

    private static String generateMessageId() {
        Random random = new Random();
        long id = 1000000000L + random.nextInt(900000000);
        return String.valueOf(id);
    }

    private static void displayMessageDetails(Message message) {
        System.out.println("\nMessage Details:");
        System.out.println("ID: " + message.getMessageId());
        System.out.println("Hash: " + message.getMessageHash());
        System.out.println("Recipient: " + message.getRecipient());
        System.out.println("Message: " + message.getContent());
        System.out.println("-----------------------------");
    }
}