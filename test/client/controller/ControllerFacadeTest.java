/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.Client;
import client.model.Tower;
import client.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Freny
 */
public class ControllerFacadeTest {
    
    public ControllerFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of blockAccount method, of class ControllerFacade.
     */
    @Test
    public void testBlockAccount() {
        System.out.println("blockAccount");
        String email = "";
        ControllerFacade instance = new ControllerFacade();
        instance.blockAccount(email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectUserByEmail method, of class ControllerFacade.
     */
    @Test
    public void testSelectUserByEmail() {
        System.out.println("selectUserByEmail");
        String token = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        ControllerFacade instance = new ControllerFacade();
        User expResult = new User();
        /*User user = new User();
        user.setEmail("user1@email.com");
        expResult.add(user);*/
        User result = instance.selectUserByEmail(token, email);
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectClientByEmail method, of class ControllerFacade.
     */
    @Test
    public void testSelectClientByEmail() {
        System.out.println("selectClientByEmail");
        String token = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        ControllerFacade instance = new ControllerFacade();
        Client expResult = new Client();
        /*Client client = new Client();
        client.setEmail("user1@email.com");
        expResult.add(client);*/
        Client result = instance.selectClientByEmail(token, email);
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of selectTowerByEmail method, of class ControllerFacade.
     */
    @Test
    public void testSelectTowerByEmailSD_01() {
        System.out.println("selectTowerByEmail");
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        String email = "user2@email.com";
        ControllerFacade instance = new ControllerFacade();
        Tower expResult = new Tower();
        /*Tower tower = new Tower();
        tower.setEmail("user2@email.com");
        expResult.add(tower);*/
        Tower result = instance.selectTowerByEmail(token, email);
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of registerClient method, of class ControllerFacade.
     */
    @Test
    public void testRegisterClientSD_01() {
        System.out.println("registerClient");
        Client client = new Client();
        ControllerFacade instance = new ControllerFacade();
        boolean expResult = true;
        boolean result = instance.registerClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
      @Test
    public void testRegisterClientSD_02() {
        System.out.println("registerClient");
        Client client = new Client();
        ControllerFacade instance = new ControllerFacade();
        boolean expResult = true;
        boolean result = instance.registerClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
    
     @Test
    public void testRegisterClientRD_01() {
        System.out.println("registerClient");
        Client client = new Client();
        ControllerFacade instance = new ControllerFacade();
        boolean expResult = true;
        boolean result = instance.registerClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
