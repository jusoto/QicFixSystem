/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
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
public class ListTowerLogicTest {
    
    private ListTowerLogic instance;
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
    
    public ListTowerLogicTest() {
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
        instance = new ListTowerLogic();
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
     * Test of getTowerList method, of class ListTowerLogic.
     */
    @Test
    public void testGetTowerList() {
        System.out.println("getTowerList");
        String token = tokenClient1;
        String email = client1.getEmail();
        String address = "8250 SW 72ND CT, Miami, FL 33143";
        Integer order = 1;
        List<Tower> list = new ArrayList<Tower>();
        list.add(tower1);
        list.add(tower2);
        when(datastoreFacade.selectTowerByAddress((Location) Matchers.anyObject(), Matchers.anyString(), Matchers.anyString())).thenReturn(list);
        List<Tower> result = instance.getTowerList(token, email, address, order);
        assertEquals(list, result);
        verify(datastoreFacade).selectTowerByAddress((Location) Matchers.anyObject(), Matchers.anyString(), Matchers.anyString());
    }
    
}
