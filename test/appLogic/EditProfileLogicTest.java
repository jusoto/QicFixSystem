/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.Tower;
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
public class EditProfileLogicTest {
    
    public EditProfileLogicTest() {
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
     * Test of updateTower method, of class EditProfileLogic.
     */
    @Test
    public void testUpdateTowerSD_01() {
        System.out.println("updateTower");
        String content = "";
        Integer id = 1;
        String email = "user2@email.com";
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateTower(content, email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
      public void testUpdateTowerSD_02() {
        System.out.println("updateTower");
        Integer id = 2;
        String content = "";
        String email = "user3@email.com";
        String token = "";
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateTower(content, email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
      
        @Test
        public void testUpdateTowerRD_01() {
        System.out.println("updateTower");
        Integer id=null;
        String content = null;
        String email = null;
        String token = null;
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateTower(content, email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
      
    /**
     * Test of getTowerById method, of class EditProfileLogic Sunny Day.
     */
    @Test
    public void testGetTowerByIdSD_01() {
        System.out.println("getTowerById");
        String email = "user2@email.com";
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        Integer id = 1;
        EditProfileLogic instance = new EditProfileLogic();
        List<Tower> expResult = new ArrayList<Tower>();
        Tower tower = new Tower();
        tower.setId(2);
        //expResult.add(tower);
        List<Tower> result = instance.getTowerById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetTowerByIdSD_02() {
        System.out.println("getTowerById");
        String email = "user3@email.com";
        String token = "12c99426-b051-4db1-ba7d-2e7f3de9f7a3";
        Integer id = 2;
        EditProfileLogic instance = new EditProfileLogic();
        List<Tower> expResult = new ArrayList<Tower>();
        Tower tower = new Tower();
        tower.setId(3);
        //expResult.add(tower);
        List<Tower> result = instance.getTowerById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetTowerByIdRD_01() {
        System.out.println("getTowerById");
        String email = "user2@email.com";
        String token = "";
        Integer id = 0;
        EditProfileLogic instance = new EditProfileLogic();
        List<Tower> expResult = new ArrayList<Tower>();
        /*Tower tower = new Tower();
        tower.setId(5);
        expResult.add(tower);*/
        List<Tower> result = instance.getTowerById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getClientById method, of class EditProfileLogic.
     */
    @Test
    public void testGetClientByIdSD_01() {
        System.out.println("getClientById");
        String email = "user1@email.com";
        String token = "";
        Integer id = 1;
        EditProfileLogic instance = new EditProfileLogic();
        List<Client> expResult = new ArrayList<Client>();
        Client client = new Client();
        client.setId(1);
        List<Client> result = instance.getClientById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testGetClientByIdSD_02() {
        System.out.println("getClientById");
        String email = "user@email.com";
        String token = "";
        Integer id = 2;
        EditProfileLogic instance = new EditProfileLogic();
        List<Client> expResult = new ArrayList<Client>();
        Client client = new Client();
        client.setId(2);
        List<Client> result = instance.getClientById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testGetClientByIdRD_01() {
        System.out.println("getClientById");
        String email = "user7@email.com";
        String token = "";
        Integer id = 7;
        EditProfileLogic instance = new EditProfileLogic();
        List<Client> expResult = new ArrayList<Client>();
        /*Client client = new Client();
        client.setId(7);
        expResult.add(client);*/
        List<Client> result = instance.getClientById(email, token, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateClient method, of class EditProfileLogic.
     */
    @Test
    public void testUpdateClientSD_01() {
        System.out.println("updateClient");
        String content = "";
        String email = "user1@email.com";
        String token = "";
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateClient(content, email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     @Test
    public void testUpdateClientSD_02() {
        System.out.println("updateClient");
        String content = "";
        String email = "user2@email.com";
        String token = "";
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateClient(content, email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testUpdateClientRD_01() {
        System.out.println("updateClient");
        String content = null;
        String email = null;
        String token = null;
        EditProfileLogic instance = new EditProfileLogic();
        boolean expResult = false;
        boolean result = instance.updateClient(content, email, token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
