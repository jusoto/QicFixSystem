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

/**
 *
 * @author Juan
 */
public class EditProfileLogicTest {
    
    private EditProfileLogic instance;
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
    
    public EditProfileLogicTest() {
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
        instance = new EditProfileLogic();
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
     * Test of updateTower method, of class EditProfileLogic.
     */
    @Test
    public void testUpdateTower() {
        System.out.println("updateTower");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        String email = tower1.getEmail();
        String token = tokenTower1;
        Integer id = tower1.getId();
        when(datastoreFacade.updateTower((Tower) Matchers.anyObject())).thenReturn(true);
        boolean result = instance.updateTower(content, email, token, id);
        assertTrue(result);
        verify(datastoreFacade).updateTower((Tower) Matchers.anyObject());
    }

    /**
     * Test of getTowerById method, of class EditProfileLogic.
     */
    @Test
    public void testGetTowerById() {
        System.out.println("getTowerById");
        String email = tower1.getEmail();
        String token = tokenTower1;
        Integer id = tower1.getId();
        List<Tower> list = new ArrayList<Tower>();
        list.add(tower1);
        when(datastoreFacade.getTowerById(Matchers.anyInt())).thenReturn(tower1);
        List<Tower> result = instance.getTowerById(email, token, id);
        assertEquals(list, result);
        verify(datastoreFacade).getTowerById(Matchers.anyInt());
    }

    /**
     * Test of getClientById method, of class EditProfileLogic.
     */
    @Test
    public void testGetClientById() {
        System.out.println("getClientById");
        String email = client1.getEmail();
        String token = tokenClient1;
        Integer id = client1.getId();
        List<Client> list = new ArrayList<Client>();
        list.add(client1);
        when(datastoreFacade.getClientById(Matchers.anyInt())).thenReturn(client1);
        List<Client> result = instance.getClientById(email, token, id);
        assertEquals(list, result);
        verify(datastoreFacade).getClientById(Matchers.anyInt());
    }

    /**
     * Test of updateClient method, of class EditProfileLogic.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("updateClient");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        String email = client1.getEmail();
        String token = tokenClient1;
        when(datastoreFacade.updateClient((Client) Matchers.anyObject())).thenReturn(true);
        boolean result = instance.updateClient(content, email, token);
        assertTrue(result);
        verify(datastoreFacade).updateClient((Client) Matchers.anyObject());
    }

    /**
     * Test of selectClientByEmail method, of class EditProfileLogic.
     */
    @Test
    public void testSelectClientByEmail() {
        System.out.println("selectClientByEmail");
        String email = client1.getEmail();
        String token = tokenClient1;
        List<Client> list = new ArrayList<Client>();
        list.add(client1);
        when(datastoreFacade.selectClientByEmail(Matchers.anyString())).thenReturn(list);
        List<Client> result = instance.selectClientByEmail(email, token);
        assertEquals(list, result);
        verify(datastoreFacade).selectClientByEmail(Matchers.anyString());
    }
    
}
