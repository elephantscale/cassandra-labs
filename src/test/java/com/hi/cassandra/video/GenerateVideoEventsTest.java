package com.hi.cassandra.video;

import com.hi.cassandra.video.GenerateVideoEvents;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark Kerzner
 */
public class GenerateVideoEventsTest {
    
    public GenerateVideoEventsTest() {
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
     * Test of main method, of class GenerateVideoEvents.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = new String[2];
        argv[0] = "2";
        argv[1] = "4";
        GenerateVideoEvents.main(argv);
        // TODO check that the expected files exists and has the expected number of records
        assertTrue(true);
    }
}