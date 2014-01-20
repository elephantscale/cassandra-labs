package com.hi.cassandra.video;

import com.hi.cassandra.video.GenerateCommentIndices;
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
public class GenerateCommentIndicesTest {
    
    public GenerateCommentIndicesTest() {
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
     * Test of main method, of class GenerateCommentIndices.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = new String[2];
        argv[0] = "2";
        argv[1] = "4";
        GenerateCommentIndices.main(argv);
        assertTrue(true);
    }
}