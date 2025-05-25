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
        String phoneNumber = "";
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

}
