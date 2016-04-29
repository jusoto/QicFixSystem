/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import appLogic.LoginLogic;
import java.util.ArrayList;
import java.util.List;
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
public class ModelFacadeTest {
    
    String token;
    
    public ModelFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         ModelFacade mf = new ModelFacade();
         token = mf.login("user1@email.com", "user1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class ModelFacade.
     */
    @Test
    public void testLoginSD_01() {
        System.out.println("login");
        String email = "user2@email.com";
        String password = "user2";
        ModelFacade instance = new ModelFacade();
        //String expResult = "user2 is succefully Login";
        String result = instance.login(email, password);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    
     @Test
    public void testLoginSD_02() {
        System.out.println("login");
        String email = "user2@email.com";
        String password = "user2";
        ModelFacade instance = new ModelFacade();
        //String expResult = "user2 is succefully Login";
        String result = instance.login(email, password);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
     @Test
    public void testLoginRD_01() {
        System.out.println("login");
        String email = "@email.com";
        String password = "user2";
        ModelFacade instance = new ModelFacade();
        //String expResult = "user2 is succefully Login";
        String result = instance.login(email, password);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    /**
     * Test of createClient method, of class ModelFacade.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        Client client = new Client();
        ModelFacade instance = new ModelFacade();
        boolean expResult = false;
        boolean result = instance.createClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createTower method, of class ModelFacade.
     */
    @Test
    public void testCreateTower() {
        System.out.println("createTower");
        Tower tower = new Tower();
        ModelFacade instance = new ModelFacade();
        boolean expResult = false;
        boolean result = instance.createTower(tower);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createRequest method, of class ModelFacade.
     */
    @Test
    public void testCreateRequest() {
        System.out.println("createRequest");
        String token = "";
        String email = "";
        Service service = new Service();
        service.setClientId(1);
        List<Tower> listTower = new ArrayList<Tower>();
        ModelFacade instance = new ModelFacade();
        boolean expResult = true;
        boolean result = instance.createRequest(token, email, service, listTower);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of acceptRequest method, of class ModelFacade.
     */
  /*  @Test
    public void testAcceptRequest() {
        System.out.println("acceptRequest");
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        String email = "user2@email.com";
        Integer serviceId = 2;
        Integer towerId = 1;
        ModelFacade instance = new ModelFacade();
        instance.acceptRequest(token, email, serviceId, towerId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of declineRequest method, of class ModelFacade.
     */
/*    @Test
    public void testDeclineRequest() {
        System.out.println("declineRequest");
        String token = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        Integer serviceId = 2;
        Integer towerId = 1;
        ModelFacade instance = new ModelFacade();
        instance.declineRequest(token, email, serviceId, towerId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getUserByEmail method, of class ModelFacade.
     */
  /*  @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String token = "";
        String email = "user2@email.com";
        ModelFacade instance = new ModelFacade();
        User expResult = new User();
       /* User user = new User();
        user.setEmail("user2@email.com");
        expResult.add(user);*/
      //  User result = instance.getUserByEmail(token, email);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    //}
//
    /**
     * Test of blockAccount method, of class ModelFacade.
     */
 /*  @Test
    public void testBlockAccount() {
        System.out.println("blockAccount");
        String email = "user1@email.com";
        ModelFacade instance = new ModelFacade();
        instance.blockAccount(email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   */ 
}
