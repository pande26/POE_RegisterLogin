/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_registerlogin;

/**
 *
 * @author RC_Student_lab
 */
import java.awt.HeadlessException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class POE_RegisterLogin {
    
    private static final Pattern SA_PHONE_PATTERN = Pattern.compile("^(\\+27|0)[0-9]{9}$");
    private static int totalMessagesSent = 0;
    
    private static final ArrayList<String> sentMessages = new ArrayList<>();
    private static final ArrayList<String> disregardedMessages = new ArrayList<>();
    private static final ArrayList<String> storedMessages = new ArrayList<>();
    private static final ArrayList<String> messageHash = new ArrayList<>();
    private static final ArrayList<String> messageID = new ArrayList<>();
    private static final ArrayList<String> senders = new ArrayList<>();
    private static final ArrayList<String> recipients = new ArrayList<>();
    private static final Random random = new Random();
    
    private static String currentUserFirstName = "";
    private static String currentUserLastName = "";
     
    public static boolean isValidSouthAfricanNumber(String phoneNumber) {
        return phoneNumber != null && SA_PHONE_PATTERN.matcher(phoneNumber).matches();
    }
    
    public static void main(String[] args) {
        try {
            RegistrationAndLogin();
            JOptionPane.showMessageDialog(null, "Welcome to QuickChat, " + currentUserFirstName + " " + currentUserLastName);
            
            boolean running = true;
            while (running) {
                String[] options = {"Basic Messaging System", "Advanced Message Management System", "Exit"};
                int choice = JOptionPane.showOptionDialog(null, 
                    "Main Menu", 
                    "QuickChat", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    options, 
                    options[0]);

                switch (choice) {
                    case 0 -> runBasicMessagingSystem();
                    case 1 -> runAdvancedMessageManagementSystem();
                    case 2 -> {
                        running = false;
                        JOptionPane.showMessageDialog(null, 
                            "Total messages sent: " + totalMessagesSent + "\nGoodbye!");
                    }
                    default -> {
                        if (choice == JOptionPane.CLOSED_OPTION) {
                            running = false;
                        }
                    }
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void RegistrationAndLogin() {
        Login objLogin = new Login();
        
        // Registration
        JOptionPane.showMessageDialog(null, "=== Registration ===");
        
        // Username
        String username;
        while (true) {
            username = JOptionPane.showInputDialog("Please enter your username");
            if (username == null) System.exit(0);
            
            if (objLogin.checkUsername(username)) {
                objLogin.setUsername(username);
                break;
            }
            JOptionPane.showMessageDialog(null, "The username is incorrectly formatted, try again");
        }
       
        // Phone number
        String phoneNumber;
        while (true) {
            phoneNumber = JOptionPane.showInputDialog("Enter your phone number");
            if (phoneNumber == null) System.exit(0);
            
            if (isValidSouthAfricanNumber(phoneNumber.trim())) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Invalid phone number format. Please try again.");
        }
       
        // Password
        String password;
        while (true) {
            password = JOptionPane.showInputDialog("Enter a password: ");
            if (password == null) System.exit(0);
            
            if (objLogin.checkPassword(password)) {
                objLogin.setPassword(password);
                break;
            }
            JOptionPane.showMessageDialog(null, "The password is incorrectly formatted, try again");
        }
      
        // User details
        currentUserFirstName = JOptionPane.showInputDialog("Enter your first name");
        if (currentUserFirstName == null) System.exit(0);
        
        currentUserLastName = JOptionPane.showInputDialog("Enter your last name");
        if (currentUserLastName == null) System.exit(0);
               
        // Login
        JOptionPane.showMessageDialog(null, "=== Login ===");
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            String loginUsername = JOptionPane.showInputDialog("Enter your username");
            if (loginUsername == null) System.exit(0);
            
            String loginPassword = JOptionPane.showInputDialog("Enter your password");
            if (loginPassword == null) System.exit(0);

            if (objLogin.loginUser(loginUsername, loginPassword)) {
                JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + currentUserFirstName + " " + currentUserLastName);
                return;
            }
            
            attempts++;
            if (attempts < MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(null, 
                    "Login failed. You have " + (MAX_ATTEMPTS - attempts) + " attempts remaining.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Maximum login attempts reached. Please try again later.");
        System.exit(0);
    }
    
    private static void runBasicMessagingSystem() {
        boolean running = true;
        
        while (running) {
            String[] options = {"Send Messages", "Show recently sent messages", "Back to Main Menu"};
            int choice = JOptionPane.showOptionDialog(null, 
                "Basic Messaging System", 
                "QuickChat", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);

            switch (choice) {
                case 0 -> sendMessages();
                case 1 -> showRecentMessages();
                case 2 -> running = false;
                default -> {
                    if (choice == JOptionPane.CLOSED_OPTION) {
                        running = false;
                    }
                }
            }
        }
    }

    private static void sendMessages() {
        String countInput = JOptionPane.showInputDialog("How many messages would you like to send?");
        if (countInput == null) return;
        
        try {
            int messageCount = Integer.parseInt(countInput);
            if (messageCount <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive number.");
                return;
            }

            for (int i = 0; i < messageCount; i++) {
                Message message = createMessage(i + 1);
                if (message == null) continue;

                String[] actions = {"Send Message", "Store Message", "Disregard Message"};
                int action = JOptionPane.showOptionDialog(null, 
                    "Message Options", 
                    "What would you like to do with this message?", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    actions, 
                    actions[0]);

                switch (action) {
                    case 0 -> {
                        sentMessages.add(message.getContent());
                        messageID.add(message.getMessageId());
                        messageHash.add(message.getMessageHash());
                        senders.add(currentUserFirstName + " " + currentUserLastName);
                        recipients.add(message.getRecipientCell());
                        totalMessagesSent++;
                        JOptionPane.showMessageDialog(null, "Message sent successfully!");
                    }
                    case 1 -> {
                        message.storeMessage();
                        storedMessages.add(message.getContent());
                        JOptionPane.showMessageDialog(null, "Message stored successfully!");
                    }
                    default -> {
                        disregardedMessages.add(message.getContent());
                        JOptionPane.showMessageDialog(null, "Message disregarded.");
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }

    private static void showRecentMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Recent Messages\n");
        int start = Math.max(0, sentMessages.size() - Math.min(5, sentMessages.size()));
        for (int i = start; i < sentMessages.size(); i++) {
            sb.append(i + 1).append(". ").append(sentMessages.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static Message createMessage(int messageNumber) {
        String recipient;
        while (true) {
            recipient = JOptionPane.showInputDialog("Enter recipient's phone number (format: +27XXXXXXXXX)");
            if (recipient == null) return null;
            
            if (Message.checkRecipientCell(recipient)) break;
            JOptionPane.showMessageDialog(null, "Invalid format. Must be +27 followed by 9 digits.");
        }

        String content;
        while (true) {
            content = JOptionPane.showInputDialog("Enter your message (max 250 characters)");
            if (content == null) return null;
            
            if (content.length() <= 250) break;
            JOptionPane.showMessageDialog(null, "Message too long. Maximum 250 characters.");
        }

        String messageId = generateMessageId();
        String messageHash = Message.createMessageHash(messageId, messageNumber, content);
        return new Message(messageId, messageNumber, recipient, content, messageHash);
    }

    private static String generateMessageId() {
        return "MSG" + (1000000000L + random.nextInt(900000000));
    }

    private static void runAdvancedMessageManagementSystem() {
        boolean running = true;
        
        while (running) {
            String[] options = {
                "Add Message",
                "Full Report",
                "Disregarded Messages", 
                "Stored Messages",
                "Delete by Hash",
                "Senders/Recipients", 
                "Longest Message",
                "Search by ID",
                "Search by Recipient",
                "Back"
            };
            
            int choice = JOptionPane.showOptionDialog(null, 
                "Message Management System", 
                "QuickChat", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);
            
            switch (choice) {
                case 0 -> addMessageAdvanced();
                case 1 -> displayFullReport();
                case 2 -> showDisregardedMessages();
                case 3 -> loadStoredMessages();
                case 4 -> deleteMessageByHash();
                case 5 -> displaySendersRecipients();
                case 6 -> displayLongestMessage();
                case 7 -> searchByMessageID();
                case 8 -> searchByRecipient();
                case 9 -> running = false;
                default -> {
                    if (choice == JOptionPane.CLOSED_OPTION) {
                        running = false;
                    }
                }
            }
        }
    }

    private static void addMessageAdvanced() {
        String recipient;
        while (true) {
            recipient = JOptionPane.showInputDialog("Enter recipient's phone number:");
            if (recipient == null) return;
            
            if (isValidSouthAfricanNumber(recipient)) break;
            JOptionPane.showMessageDialog(null, "Invalid South African number format.");
        }

        String message = JOptionPane.showInputDialog("Enter message content:");
        if (message == null) return;

        int choice = JOptionPane.showConfirmDialog(null, 
            "Send this message?", "Confirm", JOptionPane.YES_NO_OPTION);

        String ID = generateMessageID();
        int messageNumber = sentMessages.size() + 1;
        String Hash = generateHashID(ID, messageNumber);

        if (choice == JOptionPane.YES_OPTION) {
            sentMessages.add(message);
            senders.add(currentUserFirstName + " " + currentUserLastName);
            recipients.add(recipient);
            messageID.add(ID);
            messageHash.add(Hash);
            totalMessagesSent++;
            JOptionPane.showMessageDialog(null, "Message sent successfully!");
        } else {
            disregardedMessages.add(message);
            JOptionPane.showMessageDialog(null, "Message disregarded.");
        }
    }

    public static String generateMessageID() {
        String newID;
        do {
            int firstDigit = 1 + random.nextInt(9);
            int remainingDigits = random.nextInt(1_000_000_000);
            newID = firstDigit + String.format("%09d", remainingDigits);
        } while (messageID.contains(newID));
        return newID;
    }

    public static String generateHashID(String messageID, int messageNumber) {
        return messageID.substring(0, 2) + ":" + messageNumber;
    }

    public static void showDisregardedMessages() {
        if (disregardedMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No disregarded messages.");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Disregarded Messages\n");
        for (int i = 0; i < disregardedMessages.size(); i++) {
            sb.append(i + 1).append(". ").append(disregardedMessages.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void loadStoredMessages() {
        if (storedMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No stored messages.");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Stored Messages\n");
        for (int i = 0; i < storedMessages.size(); i++) {
            sb.append(i + 1).append(". ").append(storedMessages.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void displayFullReport() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages to display.");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Message Report\n");
        sb.append(String.format("%-5s | %-15s | %-20s | %-20s | %-12s | %-8s%n",
                "No.", "Sender", "Recipient", "Message", "MessageID", "Hash ID"));
        sb.append("------------------------------------------------------------------\n");

        for (int i = 0; i < sentMessages.size(); i++) {
            String msg = sentMessages.get(i);
            String truncatedMessage = msg.length() > 20 ? msg.substring(0, 17) + "..." : msg;
            sb.append(String.format("%-5d | %-15s | %-20s | %-20s | %-12s | %-8s%n",
                    i + 1,
                    senders.get(i),
                    recipients.get(i),
                    truncatedMessage,
                    messageID.get(i),
                    messageHash.get(i)));
        }
        
        sb.append("------------------------------------------------------------------\n");
        sb.append("Total Sent Messages: ").append(sentMessages.size()).append("\n");
        sb.append("Total Disregarded Messages: ").append(disregardedMessages.size()).append("\n");
        sb.append("Total Stored Messages: ").append(storedMessages.size());
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void deleteMessageByHash() {
        String hash = JOptionPane.showInputDialog("Enter Hash ID to delete:");
        if (hash == null) return;
        
        int index = messageHash.indexOf(hash);
        if (index != -1) {
            disregardedMessages.add(sentMessages.get(index));
            sentMessages.remove(index);
            senders.remove(index);
            recipients.remove(index);
            messageID.remove(index);
            messageHash.remove(index);
            JOptionPane.showMessageDialog(null, "Message disregarded and moved to archive");
        } else {
            JOptionPane.showMessageDialog(null, "Message not found");
        }
    }

    public static void displaySendersRecipients() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages to display.");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Senders and Recipients\n");
        for (int i = 0; i < sentMessages.size(); i++) {
            sb.append(i + 1).append(". From: ").append(senders.get(i))
              .append(" | To: ").append(recipients.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void displayLongestMessage() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages to display.");
            return;
        }
        
        String longest = sentMessages.get(0);
        int index = 0;
        
        for (int i = 1; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).length() > longest.length()) {
                longest = sentMessages.get(i);
                index = i;
            }
        }
        
        String message = "Longest Message\n" +
            "From: " + senders.get(index) + "\n" +
            "To: " + recipients.get(index) + "\n" +
            "Message ID: " + messageID.get(index) + "\n" +
            "Hash ID: " + messageHash.get(index) + "\n" +
            "Content: " + longest + "\n" +
            "Length: " + longest.length() + " characters";
        
        JOptionPane.showMessageDialog(null, message);
    }

    private static void searchByMessageID() {
        String id = JOptionPane.showInputDialog("Enter Message ID to search:");
        if (id == null) return;
        
        int index = messageID.indexOf(id);
        if (index != -1) {
            String message = "Message Found\n" +
                "From: " + senders.get(index) + "\n" +
                "To: " + recipients.get(index) + "\n" +
                "Message ID: " + messageID.get(index) + "\n" +
                "Hash ID: " + messageHash.get(index) + "\n" +
                "Content: " + sentMessages.get(index);
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "Message not found");
        }
    }

    private static void searchByRecipient() {
        String recipient = JOptionPane.showInputDialog("Enter Recipient to search:");
        if (recipient == null) return;
        
        boolean found = false;
        StringBuilder sb = new StringBuilder("Messages to " + recipient + "\n");
        
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equalsIgnoreCase(recipient)) {
                sb.append(i + 1).append(". From: ").append(senders.get(i)).append("\n");
                sb.append("   Message: ").append(
                    sentMessages.get(i).length() > 50 ? 
                    sentMessages.get(i).substring(0, 47) + "..." : 
                    sentMessages.get(i)).append("\n");
                sb.append("   Message ID: ").append(messageID.get(i)).append("\n");
                sb.append("   Hash ID: ").append(messageHash.get(i)).append("\n\n");
                found = true;
            }
        }
        
        if (!found) {
            sb.append("No messages found for recipient: ").append(recipient);
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
