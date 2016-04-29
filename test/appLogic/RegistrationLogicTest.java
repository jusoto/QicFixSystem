/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
import entity.Tower;
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
public class RegistrationLogicTest {
    
    private RegistrationLogic instance;
    
    @Mock
    DatastoreFacade datastoreFacade;
    
    public RegistrationLogicTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance = new RegistrationLogic();
        instance.setDatastoreFacade(datastoreFacade);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerTower method, of class RegistrationLogic.
     */
    @Test
    public void testRegisterTower() {
        System.out.println("registerTower");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        when(datastoreFacade.createTower((Tower) Matchers.anyObject())).thenReturn(true);
        boolean result = instance.registerTower(content);
        assertTrue(result);
        verify(datastoreFacade).createTower((Tower) Matchers.anyObject());
    }

    /**
     * Test of registerClient method, of class RegistrationLogic.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        String content = "[{\"email\":\"juan@email.com\",\"password\":\"juan01\",\"fname\":\"juan 01\",\"lname\":\"juan\"}]";
        when(datastoreFacade.createClient((Client) Matchers.anyObject())).thenReturn(Boolean.TRUE);
        boolean result = instance.registerClient(content);
        assertTrue(result);
        verify(datastoreFacade).createClient((Client) Matchers.anyObject());
    }
    
}
