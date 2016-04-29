/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Application;
import entity.Client;
import entity.DatastoreFacade;
import entity.Service;
import entity.Tower;
import entity.User;
import java.util.List;
import javax.security.auth.login.LoginException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mock;
import util.Location;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Juan
 */
public class AppLogicFacadeTest {

    @Mock
    DatastoreFacade datastoreFacade;

    //private static DatastoreFacade datastoreFacade;
    private final Authenticator authenticator;
    private final AppLogicFacade instance;
    Client client1;
    String tokenClient1;
    Client client2;
    String tokenClient2;
    Client client3;
    String tokenClient3;
    Tower tower1;
    String tokenTower1;
    Tower tower2;
    String tokenTower2;
    Tower tower3;
    String tokenTower3;

    public AppLogicFacadeTest() {
        authenticator = Authenticator.getInstance();
        instance = new AppLogicFacade();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws LoginException {
        MockitoAnnotations.initMocks(this);
        //datastoreFacade = mock(DatastoreFacade.class);
        client1 = new Client();
        client1.setId(1);
        client1.setEmail("user1@email.com");
        client1.setPassword("user1");
        client1.setFname("Freny");
        client1.setLname("Patel");
        tokenClient1 = authenticator.login(client1.getEmail(), client1.getPassword());
        
        client2 = new Client();
        client2.setId(2);
        client2.setEmail("user4@email.com");
        client2.setPassword("user4");
        client2.setFname("Steve");
        client2.setLname("Foo");
        tokenClient2 = authenticator.login(client2.getEmail(), client2.getPassword());
        
        client3 = new Client();
        client3.setId(3);
        client3.setEmail("user5@email.com");
        client3.setPassword("user5");
        client3.setFname("Maral");
        client3.setLname("Kargar");
        tokenClient3 = authenticator.login(client3.getEmail(), client3.getPassword());

        tower1 = new Tower();
        tower1.setId(1);
        tower1.setEmail("user2@email.com");
        tower1.setPassword("user2");
        tower1.setFname("Anjli");
        tower1.setLname("Chhatwani");
        tokenTower1 = authenticator.login(tower1.getEmail(), tower1.getPassword());

        tower2 = new Tower();
        tower2.setEmail("user3@email.com");
        tower2.setPassword("user3");
        tower2.setFname("Dionny");
        tower2.setLname("Santiago");
        tokenTower2 = authenticator.login(tower2.getEmail(), tower2.getPassword());
        
        tower3 = new Tower();
        tower3.setEmail("user6@email.com");
        tower3.setPassword("user6");
        tower3.setFname("Gregory");
        tower3.setLname("Jean-Baptiste");
        tokenTower3 = authenticator.login(tower3.getEmail(), tower3.getPassword());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class AppLogicFacade.
     *
     * @throws javax.security.auth.login.LoginException
     */
    @Test
    public void testLogin() throws LoginException {
        System.out.println("login");
        String email = client1.getEmail();
        String password = client1.getPassword();

        String expResult = tokenClient1;
        String result = instance.login(email, password);
        assertEquals(expResult, result);
        /*
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        Client client = Client.fromJson(content).get(0);
        boolean result;
        result = instance.registerTower(content);
        when(datastoreFacade.createClient(client)).thenReturn(Boolean.TRUE);
        assertTrue(result);
        verify(datastoreFacade).createClient(client);*/
    }

    /**
     * Test of logout method, of class AppLogicFacade.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        String token = "";
        String email = "";

        boolean expResult = false;
        boolean result = instance.logout(token, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class AppLogicFacade.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        Client client = Client.fromJson(content).get(0);
        when(datastoreFacade.createClient((Client) Matchers.anyObject())).thenReturn(Boolean.TRUE);
        boolean result = instance.registerTower(content);
        assertTrue(result);
        verify(datastoreFacade).createClient((Client) Matchers.anyObject());
    }

    /**
     * Test of registerTower method, of class AppLogicFacade.
     */
    @Test
    public void testRegisterTower() {
        System.out.println("registerTower");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        Tower tower = Tower.fromJson(content).get(0);
        when(datastoreFacade.createTower((Tower) Matchers.anyObject())).thenReturn(Boolean.TRUE);
        boolean result = instance.registerTower(content);
        assertTrue(result);
        verify(datastoreFacade).createTower((Tower) Matchers.anyObject());
    }

    /**
     * Test of updateClient method, of class AppLogicFacade.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("updateClient");
        String content = "";
        String token = "";
        String email = "";

        boolean expResult = false;
        boolean result = instance.updateClient(content, token, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateTower method, of class AppLogicFacade.
     */
    @Test
    public void testUpdateTower() {
        System.out.println("updateTower");
        String content = "";
        String email = "";
        String token = "";
        Integer id = null;

        boolean expResult = false;
        boolean result = instance.updateTower(content, email, token, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePickup method, of class AppLogicFacade.
     */
    @Test
    public void testUpdatePickup() {
        System.out.println("updatePickup");
        String token = "";
        String email = "";
        Integer serviceId = null;
        String pickup = "";

        boolean expResult = false;
        boolean result = instance.updatePickup(token, email, serviceId, pickup);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateDestination method, of class AppLogicFacade.
     */
    @Test
    public void testUpdateDestination() {
        System.out.println("updateDestination");
        String token = "";
        String email = "";
        Integer serviceId = null;
        String destination = "";

        boolean expResult = false;
        boolean result = instance.updateDestination(token, email, serviceId, destination);
        assertEquals(expResult, result);
    }

    /**
     * Test of requestService method, of class AppLogicFacade.
     */
    @Test
    public void testRequestService() {
        System.out.println("requestService");
        String content = "";
        String token = "";
        String email = "";

        Boolean expResult = null;
        Boolean result = instance.requestService(content, token, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of listTower method, of class AppLogicFacade.
     */
    @Test
    public void testListTower() {
        System.out.println("listTower");
        String authToken = "";
        String email = "";
        String pickup = "";
        Integer order = null;

        List<Tower> expResult = null;
        List<Tower> result = instance.listTower(authToken, email, pickup, order);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocationByAddress method, of class AppLogicFacade.
     */
    @Test
    public void testGetLocationByAddress() {
        System.out.println("getLocationByAddress");
        String address = "";

        Location expResult = null;
        Location result = instance.getLocationByAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectAllService method, of class AppLogicFacade.
     */
    @Test
    public void testSelectAllService() {
        System.out.println("selectAllService");
        String authToken = "";
        String email = "";

        List<Service> expResult = null;
        List<Service> result = instance.selectAllService(authToken, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of acceptService method, of class AppLogicFacade.
     */
    @Test
    public void testAcceptService() {
        System.out.println("acceptService");
        String content = "";
        String authToken = "";
        String email = "";
        Integer serviceId = null;

        boolean expResult = false;
        boolean result = instance.acceptService(content, authToken, email, serviceId);
        assertEquals(expResult, result);
    }

    /**
     * Test of declineService method, of class AppLogicFacade.
     */
    @Test
    public void testDeclineService() {
        System.out.println("declineService");
        String content = "";
        String authToken = "";
        String email = "";
        Integer serviceId = null;

        boolean expResult = false;
        boolean result = instance.declineService(content, authToken, email, serviceId);
        assertEquals(expResult, result);
    }

    /**
     * Test of chargeClient method, of class AppLogicFacade.
     */
    @Test
    public void testChargeClient() {
        System.out.println("chargeClient");
        String content = "";
        String authToken = "";
        String email = "";
        Integer serviceId = null;

        boolean expResult = false;
        boolean result = instance.chargeClient(content, authToken, email, serviceId);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectServiceByTowerEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectServiceByTowerEmail() {
        System.out.println("selectServiceByTowerEmail");
        String authToken = "";
        String towerEmail = "";

        List<Service> expResult = null;
        List<Service> result = instance.selectServiceByTowerEmail(authToken, towerEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddressByLocation method, of class AppLogicFacade.
     */
    @Test
    public void testGetAddressByLocation() {
        System.out.println("getAddressByLocation");
        Location location = null;

        String expResult = "";
        String result = instance.getAddressByLocation(location);
        assertEquals(expResult, result);
    }

    /**
     * Test of makePayment method, of class AppLogicFacade.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
        String token = "";
        String email = "";
        Integer serviceId = null;
        Double payment = null;

        boolean expResult = false;
        boolean result = instance.makePayment(token, email, serviceId, payment);
        assertEquals(expResult, result);
    }

    /**
     * Test of rateTower method, of class AppLogicFacade.
     */
    @Test
    public void testRateTower() {
        System.out.println("rateTower");
        String token = "";
        String email = "";
        Integer serviceId = null;
        Integer towerId = null;
        Integer rate = null;

        boolean expResult = false;
        boolean result = instance.rateTower(token, email, serviceId, towerId, rate);
        assertEquals(expResult, result);
    }

    /**
     * Test of blockUser method, of class AppLogicFacade.
     */
    @Test
    public void testBlockUser() {
        System.out.println("blockUser");
        String email = "";

        instance.blockUser(email);
    }

    /**
     * Test of selectUserByEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectUserByEmail() {
        System.out.println("selectUserByEmail");
        String email = "";
        String token = "";

        List<User> expResult = null;
        List<User> result = instance.selectUserByEmail(email, token);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectClientByEmail method, of class AppLogicFacade.
     */
    @Test
    public void testSelectClientByEmail() {
        System.out.println("selectClientByEmail");
        String email = "";
        String token = "";

        List<Client> expResult = null;
        List<Client> result = instance.selectClientByEmail(email, token);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTowerList method, of class AppLogicFacade.
     */
    @Test
    public void testGetTowerList() {
        System.out.println("getTowerList");
        String token = "";
        String email = "";
        String address = "";
        Integer order = null;

        List<Tower> expResult = null;
        List<Tower> result = instance.getTowerList(token, email, address, order);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTowerById method, of class AppLogicFacade.
     */
    @Test
    public void testGetTowerById() {
        System.out.println("getTowerById");
        String token = "";
        String email = "";
        Integer id = null;

        List<Tower> expResult = null;
        List<Tower> result = instance.getTowerById(token, email, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientById method, of class AppLogicFacade.
     */
    @Test
    public void testGetClientById() {
        System.out.println("getClientById");
        String token = "";
        String email = "";
        Integer id = null;

        List<Client> expResult = null;
        List<Client> result = instance.getClientById(token, email, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectApplication method, of class AppLogicFacade.
     */
    @Test
    public void testSelectApplication() {
        System.out.println("selectApplication");
        Integer userTypeId = null;

        List<Application> expResult = null;
        List<Application> result = instance.selectApplication(userTypeId);
        assertEquals(expResult, result);
    }

    /**
     * Test of findUserByEmail method, of class AppLogicFacade.
     */
    @Test
    public void testFindUserByEmail() {
        System.out.println("findUserByEmail");
        String email = "";

        boolean expResult = false;
        boolean result = instance.findUserByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectAllServiceByClient method, of class AppLogicFacade.
     */
    @Test
    public void testSelectAllServiceByClient() {
        System.out.println("selectAllServiceByClient");
        String authToken = "";
        String email = "";

        List<Service> expResult = null;
        List<Service> result = instance.selectAllServiceByClient(authToken, email);
        assertEquals(expResult, result);
    }

}
