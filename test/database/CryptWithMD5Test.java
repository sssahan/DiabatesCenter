/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sachithra sahan
 */
public class CryptWithMD5Test {
    
    public CryptWithMD5Test() {
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
     * Test of cryptWithMD5 method, of class CryptWithMD5.
     */
    @Test
    public void testCryptWithMD5() {
        System.out.println("cryptWithMD5");
        String pass = "m000";
        String expResult = "bf3726ba2640ac2e99e1f41c7ad061";
        String result = CryptWithMD5.cryptWithMD5(pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
