/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_registerlogin;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author RC_Student_lab
 */

class Message {
    private final String messageId;
    private final int messageNumber;
    private final String recipient;
    private final String content;
    private final String messageHash;

    public Message(String messageId, int messageNumber, String recipient, String content, String messageHash) {
        this.messageId = messageId;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.content = content;
        this.messageHash = messageHash;
    }

    // Getters
    public String getMessageId() { return messageId;}
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public String getMessageHash() { return messageHash; }

    // Validation methods
    public static boolean checkMessageId(String id) {
        return id != null && id.length() == 10 && id.matches("\\d+");
    }

    public static boolean checkRecipientCell(String number) {
        return number != null && number.matches("^\\+?\\d{10,15}$");
    }

    // Message hash creation
    public static String createMessageHash(String messageId, int messageNumber, String content) {
        String[] words = content.split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        String idPrefix = messageId.substring(0, 2);
        return (idPrefix + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Store message to JSON file
    public void storeMessage() {
        String json = String.format(
            "{\"messageId\":\"%s\",\"messageNumber\":%d,\"recipient\":\"%s\",\"content\":\"%s\",\"messageHash\":\"%s\"}",
            this.messageId,
            this.messageNumber,
            this.recipient,
            this.content.replace("\"", "\\\""),
            this.messageHash
        );

        try (FileWriter file = new FileWriter("stored_messages.json", true)) {
            file.write(json + "\n");
            file.flush();
        } catch (IOException e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
}