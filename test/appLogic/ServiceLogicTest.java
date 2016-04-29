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
import java.util.ArrayList;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import util.Location;

/**
 *
 * @author Juan
 */
public class ServiceLogicTest {
    
    private ServiceLogic instance;
    private final Authenticator authenticator;
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
    
    @Mock
    DatastoreFacade datastoreFacade;
    
    public ServiceLogicTest() {
        authenticator = Authenticator.getInstance();
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
        instance = new ServiceLogic();
        instance.setDatastoreFacade(datastoreFacade);
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
     * Test of createService method, of class ServiceLogic.
     */
    @Test
    public void testCreateService() {
        System.out.println("createService");
        String content = "[{\n" +
"\"cityDestination\": \"Miami\"\n" +
"\"cityPickup\": \"Miami\"\n" +
"\"clientDescription\": \"Near ECS Building\"\n" +
"\"clientId\": 1\n" +
"\"id\": 1\n" +
"\"latitudePickup\": 25.694021\n" +
"\"longitudePickup\": -80.310819\n" +
"\"stateDestination\": \"FL\"\n" +
"\"statePickup\": \"FL\"\n" +
"\"streetAddressDestination\": \"8250 SW 72nd Ct\"\n" +
"\"streetAddressPickup\": \"11200 SW 8th St\"\n" +
"\"towerDescription\": \"The car was delivered\"\n" +
"\"zipcodeDestination\": \"33199\"\n" +
"\"zipcodePickup\": \"33199\"\n" +
"}][{}]";
        String token = tokenClient1;
        String email = client1.getEmail();
        when(datastoreFacade.createRequest((Service) Matchers.anyObject(), (List<Tower>) Matchers.anyObject())).thenReturn(true);
        Boolean result = instance.createService(content, token, email);
        assertTrue(result);
        verify(datastoreFacade).createRequest((Service) Matchers.anyObject(), (List<Tower>) Matchers.anyObject());
    }

    /**
     * Test of selectServiceByTowerEmail method, of class ServiceLogic.
     */
    @Test
    public void testSelectServiceByTowerEmail() {
        System.out.println("selectServiceByTowerEmail");
        String authToken = tokenTower1;
        String towerEmail = tower1.getEmail();
        List<Service> list = new ArrayList<Service>();
        when(datastoreFacade.selectServiceByTowerEmail(Matchers.anyString())).thenReturn(list);
        List<Service> result = instance.selectServiceByTowerEmail(authToken, towerEmail);
        assertEquals(list, result);
        verify(datastoreFacade).selectServiceByTowerEmail(Matchers.anyString());
    }

    /**
     * Test of chargeClient method, of class ServiceLogic.
     */
    @Test
    public void testChargeClient() {
        System.out.println("chargeClient");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        String authToken = tokenTower1;
        String email = tower1.getEmail();
        Integer serviceId = 1;
        when(datastoreFacade.chargeService(Matchers.anyString(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.chargeClient(content, authToken, email, serviceId);
        assertTrue(result);
        verify(datastoreFacade).chargeService(Matchers.anyString(), Matchers.anyInt());
    }

    /**
     * Test of declineService method, of class ServiceLogic.
     */
    @Test
    public void testDeclineService() {
        System.out.println("declineService");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        String authToken = tokenTower1;
        String email = tower1.getEmail();
        Integer serviceId = 1;
        when(datastoreFacade.declineService(Matchers.anyString(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.declineService(content, authToken, email, serviceId);
        assertTrue(result);
        verify(datastoreFacade).declineService(Matchers.anyString(), Matchers.anyInt());
    }

    /**
     * Test of listTower method, of class ServiceLogic.
     */
    @Test
    public void testListTower() {
        System.out.println("listTower");
        String token = tokenClient1;
        String email = client1.getEmail();
        String pickup = "8250 SW 72ND CT, Miami, FL 33143";
        Integer order = 1;
        List<Tower> list = new ArrayList<Tower>();
        list.add(tower1);
        when(datastoreFacade.selectAllTower((Location) Matchers.anyObject(), Matchers.anyInt())).thenReturn(list);
        List<Tower> result = instance.listTower(token, email, pickup, order);
        assertEquals(list, result);
        verify(datastoreFacade).selectAllTower((Location) Matchers.anyObject(), Matchers.anyInt());
    }

    /**
     * Test of selectAllService method, of class ServiceLogic.
     */
    @Test
    public void testSelectAllService() {
        System.out.println("selectAllService");
        String authToken = tokenTower1;
        String email = tower1.getEmail();
        List<Service> list = new ArrayList<Service>();
        when(datastoreFacade.selectAllService()).thenReturn(list);
        List<Service> result = instance.selectAllService(authToken, email);
        assertEquals(list, result);
        verify(datastoreFacade).selectAllService();
    }

    /**
     * Test of acceptService method, of class ServiceLogic.
     */
    @Test
    public void testAcceptService() {
        System.out.println("acceptService");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        String authToken = tokenTower1;
        String email = tower1.getEmail();
        Integer serviceId = 1;
        when(datastoreFacade.acceptService(Matchers.anyString(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.acceptService(content, authToken, email, serviceId);
        assertTrue(result);
        verify(datastoreFacade).acceptService(Matchers.anyString(), Matchers.anyInt());
    }

    /**
     * Test of updatePickup method, of class ServiceLogic.
     */
    @Test
    public void testUpdatePickup() {
        System.out.println("updatePickup");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer serviceId = 1;
        String pickup = "8250 SW 72ND CT, Miami, FL 33143";
        when(datastoreFacade.updatePickup(Matchers.anyString(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.updatePickup(token, email, serviceId, pickup);
        assertTrue(result);
        verify(datastoreFacade).updatePickup(Matchers.anyString(), Matchers.anyInt());
    }

    /**
     * Test of updateDestination method, of class ServiceLogic.
     */
    @Test
    public void testUpdateDestination() {
        System.out.println("updateDestination");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer serviceId = 1;
        String destination = "8250 SW 72ND CT, Miami, FL 33143";
        when(datastoreFacade.updateDestination(Matchers.anyString(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.updateDestination(token, email, serviceId, destination);
        assertTrue(result);
        verify(datastoreFacade).updateDestination(Matchers.anyString(), Matchers.anyInt());
    }

    /**
     * Test of makePayment method, of class ServiceLogic.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer serviceId = 1;
        Double payment = 80.;        
        when(datastoreFacade.makePayment(Matchers.anyDouble(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.makePayment(token, email, serviceId, payment);
        assertTrue(result);
        verify(datastoreFacade).makePayment(Matchers.anyDouble(), Matchers.anyInt());
    }

    /**
     * Test of rateTower method, of class ServiceLogic.
     */
    @Test
    public void testRateTower() {
        System.out.println("rateTower");
        String token = tokenClient1;
        String email = client1.getEmail();
        Integer serviceId = 1;
        Integer towerId = tower1.getId();
        Integer rate = 5;
        when(datastoreFacade.rateTower(Matchers.anyInt(), Matchers.anyInt(), Matchers.anyInt())).thenReturn(true);
        boolean result = instance.rateTower(token, email, serviceId, towerId, rate);
        assertTrue(result);
        verify(datastoreFacade).rateTower(Matchers.anyInt(), Matchers.anyInt(), Matchers.anyInt());
    }
    
}
