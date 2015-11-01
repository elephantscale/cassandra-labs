package com.es.cassandra;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class FirstTest {

    private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);

    @Test
    public void testConnect() {
        logger.info("testConnect");
        assertTrue(true);
    }
}
