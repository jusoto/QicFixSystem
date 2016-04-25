/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Location;

/**
 *
 * @author Juan
 */
public class DatastoreFacadeTest {
    
    public DatastoreFacadeTest() {
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
     * Test of createClient method, of class DatastoreFacade.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        Client client = new Client();
        client.setFname("Steve");
        client.setLname("Foo");
        client.setEmail("steve.foo@gmail.com");
        DatastoreFacade instance = new DatastoreFacade();
        instance.createClient(client);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    /**
     * Test of createTower method, of class DatastoreFacade.
     */
    @Test
    public void testCreateTower() {
        System.out.println("createTower");
        Tower tower = new Tower();
        tower.setFname("Juan");
        tower.setLname("Sotomayor");
        tower.setCompanyName("Tow Company");
        tower.setPermitNumber("123457894");
        DatastoreFacade instance = new DatastoreFacade();
        instance.createTower(tower);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createRequest method, of class DatastoreFacade.
     */
    @Test
    public void testCreateRequest() {
        System.out.println("createRequest");
        Service service = null;
        List<Tower> listTower = null;
        DatastoreFacade instance = new DatastoreFacade();
        instance.createRequest(service, listTower);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of acceptRequest method, of class DatastoreFacade.
     */
    @Test
    public void testAcceptRequest() {
        System.out.println("acceptRequest");
        Integer serviceId = null;
        Integer towerId = null;
        DatastoreFacade instance = new DatastoreFacade();
        instance.acceptRequest(serviceId, towerId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of declineRequest method, of class DatastoreFacade.
     */
    @Test
    public void testDeclineRequest() {
        System.out.println("declineRequest");
        Integer serviceId = null;
        Integer towerId = null;
        DatastoreFacade instance = new DatastoreFacade();
        instance.declineRequest(serviceId, towerId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateUser method, of class DatastoreFacade.
     */
    @Test
    public void testValidateUser() {
        System.out.println("validateUser");
        String email = "";
        String password = "";
        DatastoreFacade instance = new DatastoreFacade();
        boolean expResult = false;
        boolean result = instance.validateUser(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectServiceByTowerEmail method, of class DatastoreFacade.
     */
    @Test
    public void testSelectServiceByTowerEmail() {
        System.out.println("selectServiceByTowerEmail");
        String towerEmail = "";
        DatastoreFacade instance = new DatastoreFacade();
        List<Service> expResult = null;
        List<Service> result = instance.selectServiceByTowerEmail(towerEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chargeService method, of class DatastoreFacade.
     */
    @Test
    public void testChargeService() {
        System.out.println("chargeService");
        String email = "";
        Integer serviceId = null;
        DatastoreFacade instance = new DatastoreFacade();
        boolean expResult = false;
        boolean result = instance.chargeService(email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of declineService method, of class DatastoreFacade.
     */
    @Test
    public void testDeclineService() {
        System.out.println("declineService");
        String email = "";
        Integer serviceId = null;
        DatastoreFacade instance = new DatastoreFacade();
        boolean expResult = false;
        boolean result = instance.declineService(email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of acceptService method, of class DatastoreFacade.
     */
    @Test
    public void testAcceptService() {
        System.out.println("acceptService");
        String email = "";
        Integer serviceId = null;
        DatastoreFacade instance = new DatastoreFacade();
        boolean expResult = false;
        boolean result = instance.acceptService(email, serviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllService method, of class DatastoreFacade.
     */
    @Test
    public void testSelectAllService() {
        System.out.println("selectAllService");
        DatastoreFacade instance = new DatastoreFacade();
        List<Service> expResult = new ArrayList<Service>();
        Service service = new Service();
        service.setId(1);
        //TODO add all the values
        expResult.add(service);
        List<Service> result = instance.selectAllService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        ///fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllTower method, of class DatastoreFacade.
     */
    @Test
    public void testSelectAllTower() {
        System.out.println("selectAllTower");
        Location location = null;
        Integer order = null;
        DatastoreFacade instance = new DatastoreFacade();
        List<Tower> expResult = null;
        List<Tower> result = instance.selectAllTower(location, order);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectUserByEmail method, of class DatastoreFacade.
     */
    @Test
    public void testSelectUserByEmail() {
        System.out.println("selectUserByEmail");
        String email = "";
        DatastoreFacade instance = new DatastoreFacade();
        List<User> expResult = null;
        List<User> result = instance.selectUserByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectClientByEmail method, of class DatastoreFacade.
     */
    @Test
    public void testSelectClientByEmail() {
        System.out.println("selectClientByEmail");
        String email = "";
        DatastoreFacade instance = new DatastoreFacade();
        List<Client> expResult = null;
        List<Client> result = instance.selectClientByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
