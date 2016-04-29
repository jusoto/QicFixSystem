/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
import entity.Service;
import entity.Tower;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Location;
import static org.mockito.Mockito.*;

/**
 *
 * @author Freny
 */
public class AppLogicFacadeTest_1 {
    
    private static DatastoreFacade datastoreFacade;
    private final Authenticator authenticator;
    Client client1;
    String tokenClient1;
    Tower tower1;
    String tokenTower1;
    Tower tower2;
    String tokenTower2;
    
    public AppLogicFacadeTest_1() {
        authenticator = Authenticator.getInstance();
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        datastoreFacade = mock(DatastoreFacade.class);
        client1 = new Client();
        client1.setId(1);
        client1.setEmail("user1@email.com");
        client1.setPassword("user1");
        client1.setFname("User 1");
        client1.setLname("");
        try {
            tokenClient1 = authenticator.login(client1.getEmail(), client1.getPassword());
        } catch (LoginException ex) {
            Logger.getLogger(AppLogicFacadeTest_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        tower1 = new Tower();
        tower1.setEmail("user2@email.com");
        tower1.setPassword("user2");
        tower1.setFname("User 2");
        tower1.setLname("");
        try {
            tokenTower1 = authenticator.login(tower1.getEmail(), tower1.getPassword());
        } catch (LoginException ex) {
            Logger.getLogger(AppLogicFacadeTest_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        tower2 = new Tower();
        tower2.setEmail("user3@email.com");
        tower2.setPassword("user3");
        tower2.setFname("User 3");
        tower2.setLname("");
        try {
            tokenTower2 = authenticator.login(tower2.getEmail(), tower2.getPassword());
        } catch (LoginException ex) {
            Logger.getLogger(AppLogicFacadeTest_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of requestService method, of class AppLogicFacade.
     */
    @Test
    public void testRequestService() {
        System.out.println("requestService");
        String content = "";
        String authToken = tokenClient1;
        String email = client1.getEmail();
        AppLogicFacade instance = new AppLogicFacade();
        boolean expResult = false;
        boolean result = instance.requestService(content, authToken, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of listTower method, of class AppLogicFacade.
     */
    @Test
    public void testListTower() {
        System.out.println("listTower");
        String authToken = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        String pickup = "10750 SW 11th St, Miami, FL 33174 ";
        Integer order = 3;
        AppLogicFacade instance = new AppLogicFacade();
        List<Tower> expResult = new ArrayList<Tower>();
        
        Tower tower = new Tower();
        tower.setEmail("user2@email.com");
        tower.setLatitude(25.770083);
        tower.setLongitude(-80.345054);
        expResult.add(tower);
        
        Tower tower2 = new Tower();
        tower.setEmail("user3@email.com");
        tower.setLatitude(25.701735);
        tower.setLongitude(-80.345054);
        expResult.add(tower2);
        
        List<Tower> result = instance.listTower(authToken, email, pickup, order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class AppLogicFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String email = "user1@email.com";
        String password = "user1";
        AppLogicFacade instance = new AppLogicFacade();
        String expResult = "True";
        String result = instance.login(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        ///fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class AppLogicFacade.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        String email = "user1@email.com";
        String token = "";
        AppLogicFacade instance = new AppLogicFacade();
        instance.logout(token, email);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocationByAddress method, of class AppLogicFacade.
     */
    @Test
    public void testGetLocationByAddress() {
        System.out.println("getLocationByAddress");
        String address = "11200 SW 8th St,Miami,FL-33199 ";
        AppLogicFacade instance = new AppLogicFacade();
        Location expResult = new Location(25.759361, -80.373731);
        Location result = instance.getLocationByAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllService method, of class AppLogicFacade.
     */
    @Test
    public void testSelectAllService() {
        System.out.println("selectAllService");
        String authToken = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        AppLogicFacade instance = new AppLogicFacade();
        List<Service> expResult = new ArrayList<Service>();
        Service service = new Service();
        service.setId(1);
        expResult.add(service);
        List<Service> result = instance.selectAllService(authToken, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of acceptService method, of class AppLogicFacade.
     */
    @Test
    public void testAcceptService() {
        System.out.println("acceptService");
        String content = "";
        String authToken = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        String email = "user2@email.com";
        Integer serviceId = 4;
        AppLogicFacade instance = new AppLogicFacade();
        boolean expResult = false;
        boolean result = instance.acceptService(content, authToken, email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of declineService method, of class AppLogicFacade.
     */
    @Test
    public void testDeclineService() {
        System.out.println("declineService");
        String content = "";
        String authToken = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        String email = "user2@email.com";
        Integer serviceId = 3;
        AppLogicFacade instance = new AppLogicFacade();
        boolean expResult = false;
        boolean result = instance.declineService(content, authToken, email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chargeClient method, of class AppLogicFacade.
     */
    @Test
    public void testChargeService() {
        System.out.println("chargeService");
        String content = "";
        String authToken = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String email = "user1@email.com";
        Integer serviceId = 1;
        AppLogicFacade instance = new AppLogicFacade();
        boolean expResult = false;
        boolean result = instance.chargeClient(content, authToken, email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectServiceByTowerEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectServiceByTowerEmail() {
        System.out.println("selectServiceByTowerEmail");
        String authToken = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        String towerEmail = "user2@email.com";
        AppLogicFacade instance = new AppLogicFacade();
        List<Service> expResult = null;
        List<Service> result = instance.selectServiceByTowerEmail(authToken, towerEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressByLocation method, of class AppLogicFacade.
     */
    @Test
    public void testGetAddressByLocation() {
        System.out.println("getAddressByLocation");
        Location location = new Location(25.757397, -80.369570);
        AppLogicFacade instance = new AppLogicFacade();
        String expResult = "true";
        String result = instance.getAddressByLocation(location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updatePickup method, of class AppLogicFacade.
     */
    @Test
    public void testUpdatePickup() {
        System.out.println("updatePickup");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer idservice = null;
        String pickup = "10750 SW 11th St, Miami, FL 33174";
        AppLogicFacade instance = new AppLogicFacade();
        instance.updatePickup(token, email, idservice, pickup);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updateDestination method, of class AppLogicFacade.
     */
    @Test
    public void testUpdateDestination() {
        System.out.println("updateDestination");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer idservice = 2;
        String destination = "10750 SW 11th St, Miami, FL 33174";
        AppLogicFacade instance = new AppLogicFacade();
        instance.updateDestination(token, email, idservice, destination);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }    

    /**
     * Test of makePayment method, of class AppLogicFacade.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer idservice = 2;
        Double payment = 40.96;
        AppLogicFacade instance = new AppLogicFacade();
        instance.makePayment(token, email, idservice, payment);
        // TODO review the generated test code and remove the default call to fail.
     //  fail("The test case is a prototype.");
    }

    /**
     * Test of rateTower method, of class AppLogicFacade.
     */
    @Test
    public void testRateTower() {
        System.out.println("rateTower");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer serviceId = 2;
        Integer towerId = 1;
        Integer rate = 60;
        AppLogicFacade instance = new AppLogicFacade();
        instance.rateTower(token, email, serviceId, towerId, rate);
    }

    /**
     * Test of registrationTower method, of class AppLogicFacade.
     */
    @Test
    public void testRegistrationTower() {
        System.out.println("registrationTower");
        AppLogicFacade instance = new AppLogicFacade();
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        Tower tower = Tower.fromJson(content).get(0);
        boolean result;
        result = instance.registerTower(content);
        when(datastoreFacade.createTower(tower)).thenReturn(Boolean.TRUE);
        assertTrue(result);
        verify(datastoreFacade, times(1)).createTower(tower);
    }

    /**
     * Test of createClient method, of class AppLogicFacade.
     */
    @Test
    public void testRegisterClient_SD_01() {
        System.out.println("createClient");
        AppLogicFacade instance = new AppLogicFacade();
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        Client client = Client.fromJson(content).get(0);
        when(datastoreFacade.createClient(client)).thenReturn(Boolean.TRUE);
        Boolean result = instance.registerClient(content);
        assertTrue(result);
        verify(datastoreFacade, times(1)).createClient(client);
    }

    /**
     * Test of selectUserByEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectUserByEmail() {
        System.out.println("selectUserByEmail");
        String email = "user1@email.com";
        String token = "8336ed2d-9ade-4139-993e-55c56094d3be";
        AppLogicFacade instance = new AppLogicFacade();
        List<User> expResult = null;
        List<User> result = instance.selectUserByEmail(email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllUser method, of class AppLogicFacade.
     */
    @Test
    public void testSelectAllUser() {
        System.out.println("selectAllUser");
        String email = "user2@email.com";
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        AppLogicFacade instance = new AppLogicFacade();
        List<User> expResult = null;
        List<User> result = null;//instance.selectAllUser(email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of selectClientByEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectClientByEmail() {
        System.out.println("selectClientByEmail");
        String email = "8336ed2d-9ade-4139-993e-55c56094d3be";
        String token = "user1@email.com";
        AppLogicFacade instance = new AppLogicFacade();
        List<Client> expResult = null;
        List<Client> result = instance.selectClientByEmail(email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }
    
}
