/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.Tower;
import javax.security.auth.login.LoginException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class AuthenticatorTest {
    
    private final Authenticator instance;
    Client client1;
    String tokenClient1;
    
    public AuthenticatorTest() {
        instance = Authenticator.getInstance();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws LoginException {
        client1 = new Client();
        client1.setId(1);
        client1.setEmail("user1@email.com");
        client1.setPassword("user1");
        client1.setFname("Freny");
        client1.setLname("Patel");
        tokenClient1 = instance.login(client1.getEmail(), client1.getPassword());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class Authenticator.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String email = client1.getEmail();
        String password = client1.getPassword();
        String expResult = tokenClient1;
        String result = instance.login(email, password);
        assertEquals(expResult!=null, result!=null);
    }
    
}
