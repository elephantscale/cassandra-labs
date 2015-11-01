package com.es.cassandra;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class FirstTest {

    private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);

    @Test
    public void testConnect() throws Exception {
        logger.info("testConnect");
        String args[] = { "myflix" };
        TestConnection.main(args);
        assertTrue(true);
    }
}
