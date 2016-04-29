/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.User;
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
public class ServiceLogicTest_1 {
    
   String user1;
    String token1;
    String user2;
    String token2;
            
    public ServiceLogicTest_1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        LoginLogic login = new LoginLogic();
        token1 = login.login("user1@email.com", "user1");
        token2 = login.login("user2@email.com", "user2");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createService method, of class ServiceLogic.
     */
    @Test
    public void testCreateServiceSD_01() {
        System.out.println("createService");
        String content = "[{\"clientId\":1,\"streetAddressPickup\":\"8250 SW 72nd Ct\",\"cityPickup\":\"Miami\",\"statePickup\":\"FL\",\"zipcodePickup\":\"33143\",\"streetAddressDestination\":\"7824 NW 71TH ST\",\"cityDestination\":\"Miami\",\"stateDestination\":\"FL\",\"zipcodeDestination\":\"33143\"}][{\"id\":1},{\"id\":2}]";
        String token = this.token1;
        String email = "user1@email.com";
        ServiceLogic instance = new ServiceLogic();
        boolean expResult = false;
        boolean result = instance.createService(content, token, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
      @Test
    public void testCreateServiceSD_02() {
        System.out.println("createService");
        String content = "[{\"clientId\":1,\"streetAddressPickup\":\"8250 SW 72nd Ct\",\"cityPickup\":\"Miami\",\"statePickup\":\"FL\",\"zipcodePickup\":\"33143\",\"streetAddressDestination\":\"7824 NW 71TH ST\",\"cityDestination\":\"Miami\",\"stateDestination\":\"FL\",\"zipcodeDestination\":\"33143\"}][{\"id\":1},{\"id\":2}]";
        String token = this.token1;
        String email = "user1@email.com";
        ServiceLogic instance = new ServiceLogic();
        boolean expResult = false;
        boolean result = instance.createService(content, token1, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
      @Test
    public void testCreateServiceRD_01() {
        System.out.println("createService");
        String content = "";
        String token = "";
        String email = "";
        ServiceLogic instance = new ServiceLogic();
        boolean expResult = false;
        boolean result = instance.createService(content, token, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

