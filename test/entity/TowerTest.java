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
 * @author Freny
 */
public class TowerTest {
    
    public TowerTest() {
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
     * Test of getId method, of class Tower.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tower instance = new Tower();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tower.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Tower instance = new Tower();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyName method, of class Tower.
     */
    @Test
    public void testGetCompanyName() {
        System.out.println("getCompanyName");
        Tower instance = new Tower();
        String expResult = null;
        String result = instance.getCompanyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyName method, of class Tower.
     */
    @Test
    public void testSetCompanyName() {
        System.out.println("setCompanyName");
        String companyName = "";
        Tower instance = new Tower();
        instance.setCompanyName(companyName);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPermitNumber method, of class Tower.
     */
    @Test
    public void testGetPermitNumber() {
        System.out.println("getPermitNumber");
        Tower instance = new Tower();
        String expResult = null;
        String result = instance.getPermitNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setPermitNumber method, of class Tower.
     */
    @Test
    public void testSetPermitNumber() {
        System.out.println("setPermitNumber");
        String permitNumber = "";
        Tower instance = new Tower();
        instance.setPermitNumber(permitNumber);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatitude method, of class Tower.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Tower instance = new Tower();
        Double expResult = null;
        Double result = instance.getLatitude();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setLatitude method, of class Tower.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        Double latitude = null;
        Tower instance = new Tower();
        instance.setLatitude(latitude);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLongitude method, of class Tower.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Tower instance = new Tower();
        Double expResult = null;
        Double result = instance.getLongitude();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setLongitude method, of class Tower.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        Double longitude = null;
        Tower instance = new Tower();
        instance.setLongitude(longitude);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceMile method, of class Tower.
     */
    @Test
    public void testGetPriceMile() {
        System.out.println("getPriceMile");
        Tower instance = new Tower();
        Double expResult = null;
        Double result = instance.getPriceMile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriceMile method, of class Tower.
     */
    @Test
    public void testSetPriceMile() {
        System.out.println("setPriceMile");
        Double priceMile = null;
        Tower instance = new Tower();
        instance.setPriceMile(priceMile);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class Tower.
     */
   

    /**
     * Test of create method, of class Tower.
     */
   

    /**
     * Test of selectById method, of class Tower.
     */
 

   

    /**
     * Test of getIdByEmail method, of class Tower.
  
    /**
     * Test of selectTowerByEmail method, of class Tower.
     */
   

    /**
     * Test of toJson method, of class Tower.
     */

    /**
     * Test of fromJson method, of class Tower.
     */
    @Test
    public void testFromJson() {
        System.out.println("fromJson");
        String json = "";
        List<Tower> expResult = null;
        List<Tower> result = Tower.fromJson(json);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of SelectByStateCity method, of class Tower.
     */
  

    /**
     * Test of SelectByRating method, of class Tower.
     */
    
    /**
     * Test of SelectByPrice method, of class Tower.
     */
  

    /**
     * Test of updateTower method, of class Tower.
     */
   
    
}
