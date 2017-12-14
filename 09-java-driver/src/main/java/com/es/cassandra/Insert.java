package com.es.cassandra;

import java.text.NumberFormat;
import java.util.logging.SimpleFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class Insert {
  
  private static final Logger logger = LoggerFactory.getLogger(Insert.class);

  public static void main(String[] args) throws Exception {

    NumberFormat nf = NumberFormat.getInstance();

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    logger.info("### connected to " + cluster.getClusterName());

    // TODO-1 : connect to keyspace
    Session session = cluster.connect("???");

    long t1 = System.currentTimeMillis();
    int maxUsers = 10; // change this to adjust # of records inserted
    for (int i = 1; i < maxUsers; i++) {
      String user_name = "user-" + i;
      String fname = "Joe " + i;
      String lname = "Smith " + i;
      String emails = "{" + "'user-" + i + "@email.com'" + "}";

      // construct CQL
      String cql = String.format(
          "INSERT INTO users(user_name, fname, lname, emails) "
              + "VALUES ('{}', '{}', '{}',  {});",
          user_name, fname, lname, emails);

      // debug print, turn off for benchmarking :-)
      logger.debug("### " + cql);

      // TODO-2 : execute cql in session
      // session......(cql);
    }
    long t2 = System.currentTimeMillis();

    logger.info(
        "".format("### Inserted {} users in {} milli secs. ({} writes / sec)",
            nf.format(maxUsers), 
            nf.format(t2 - t1),
            nf.format(maxUsers * 1000.0 / (t2 - t1))));

    session.close();
    cluster.close();
  }

}
