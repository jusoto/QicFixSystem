/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

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
public class LoginLogicTest_1 {
    
    public LoginLogicTest_1() {
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
     * Test of login method, of class LoginLogic.
     */
    @Test
    public void testLoginSD_01() {
        System.out.println("login");
        String email = "user1@email.com";
        String password = "user1";
        LoginLogic instance = new LoginLogic();
        //String expResult = "null";
        String result = instance.login(email, password);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLoginSD_02() {
        System.out.println("login");
        String email = "user2@email.com";
        String password = "user2";
        LoginLogic instance = new LoginLogic();
        //String expResult = "null";
        String result = instance.login(email, password);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLoginRD_01() {
        System.out.println("login");
        String email = "";
        String password = "";
        LoginLogic instance = new LoginLogic();
        //String expResult = "null";
        String result = instance.login(email, password);
        //System.out.println(result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
