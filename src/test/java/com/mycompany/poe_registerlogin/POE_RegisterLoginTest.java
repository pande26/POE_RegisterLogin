/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_registerlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class POE_RegisterLoginTest {

    public POE_RegisterLoginTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup class");
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Setup class");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidSouthAfricanNumber method, of class POE_RegisterLogin.
     */
    @Test
    public void testIsValidSouthAfricanNumber() {
        System.out.println("isValidSouthAfricanNumber");
        String phoneNumber = "+27636711709";
        boolean expResult = false;
        boolean result = POE_RegisterLogin.isValidSouthAfricanNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class POE_RegisterLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        POE_RegisterLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class POE_RegisterLogin.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        POE_RegisterLogin.addMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateMessageID method, of class POE_RegisterLogin.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        String expResult = "Auto generated";
        String result = POE_RegisterLogin.generateMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateHashID method, of class POE_RegisterLogin.
     */
    @Test
    public void testGenerateHashID() {
        System.out.println("generateHashID");
        String messageID = "Auto generated";
        int messageNumber = 0;
        String expResult = "";
        String result = POE_RegisterLogin.generateHashID(messageID, messageNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showDisregardedMessages method, of class POE_RegisterLogin.
     */
    @Test
    public void testShowDisregardedMessages() {
        System.out.println("showDisregardedMessages");
        POE_RegisterLogin.showDisregardedMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadStoredMessages method, of class POE_RegisterLogin.
     */
    @Test
    public void testLoadStoredMessages() {
        System.out.println("loadStoredMessages");
        POE_RegisterLogin.loadStoredMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullReport method, of class POE_RegisterLogin.
     */
    @Test
    public void testDisplayFullReport() {
        System.out.println("displayFullReport");
        POE_RegisterLogin.displayFullReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMessageByHash method, of class POE_RegisterLogin.
     */
    @Test
    public void testDeleteMessageByHash() {
        System.out.println("deleteMessageByHash");
        String hash = "";
        POE_RegisterLogin.deleteMessageByHash(hash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySendersRecipients method, of class POE_RegisterLogin.
     */
    @Test
    public void testDisplaySendersRecipients() {
        System.out.println("displaySendersRecipients");
        POE_RegisterLogin.displaySendersRecipients();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class POE_RegisterLogin.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        POE_RegisterLogin.displayLongestMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class POE_RegisterLogin.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        String id = "";
        POE_RegisterLogin.searchByMessageID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByRecipient method, of class POE_RegisterLogin.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        String recipient = "";
        POE_RegisterLogin.searchByRecipient(recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
