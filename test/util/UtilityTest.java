/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import javax.ws.rs.core.Response;
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
public class UtilityTest {
    
    public UtilityTest() {
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
     * Test of StringToDate method, of class Utility.
     */
    @Test
    public void testStringToDate() {
        System.out.println("StringToDate");
        String strDate = "";
        Date expResult = null;
        Date result = Utility.StringToDate(strDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of ConvertirDateToString method, of class Utility.
     */
    @Test
    public void testConvertirDateToString() {
        System.out.println("ConvertirDateToString");
        Date date = null;
        String expResult = "";
        String result = Utility.ConvertirDateToString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassFormat method, of class Utility.
     */
    @Test
    public void testValidatePassFormat() {
        System.out.println("validatePassFormat");
        String pass = "";
        boolean expResult = false;
        boolean result = Utility.validatePassFormat(pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmailFormat method, of class Utility.
     */
    @Test
    public void testValidateEmailFormat() {
        System.out.println("validateEmailFormat");
        String email = "";
        boolean expResult = false;
        boolean result = Utility.validateEmailFormat(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocationFromAddress method, of class Utility.
     */
    @Test
    public void testGetLocationFromAddress() throws Exception {
        System.out.println("getLocationFromAddress");
        String address = "8250 SW 72ND CT, Miami FL, 33143";
        Location expResult = new Location(83.11115,-83.14545);
        Location result = Utility.getLocationFromAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatLongPositions method, of class Utility.
     */
    @Test
    public void testGetLatLongPositions() throws Exception {
        System.out.println("getLatLongPositions");
        String address = "";
        String[] expResult = null;
        String[] result = Utility.getLatLongPositions(address);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getNoCacheResponseBuilder method, of class Utility.
     */
    @Test
    public void testGetNoCacheResponseBuilder() {
        System.out.println("getNoCacheResponseBuilder");
        Response.Status status = null;
        Response.ResponseBuilder expResult = null;
        Response.ResponseBuilder result = Utility.getNoCacheResponseBuilder(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of distanceWithHeight method, of class Utility.
     */
    @Test
    public void testDistanceWithHeight() {
        System.out.println("distanceWithHeight");
        double lat1 = 0.0;
        double lat2 = 0.0;
        double lon1 = 0.0;
        double lon2 = 0.0;
        double el1 = 0.0;
        double el2 = 0.0;
        double expResult = 0.0;
        double result = Utility.distanceWithHeight(lat1, lat2, lon1, lon2, el1, el2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
