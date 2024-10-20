package com.es.cassandra;

import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/3.0/index.html

public class InsertAnswer {
  private static final Logger logger = LoggerFactory.getLogger(InsertAnswer.class);

  public static void main(String[] args) throws Exception {

    NumberFormat nf = NumberFormat.getInstance();

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    logger.info("### connected to " + cluster.getClusterName());

    Session session = cluster.connect("myflix");

    long t1 = System.currentTimeMillis();
    int maxUsers = 10; // change this to adjust # of records inserted
    for (int i = 1; i < maxUsers; i++) {
      String user_name = "user-" + i;
      String fname = "Joe " + i;
      String lname = "Smith " + i;
      String emails = "{" + "'user-" + i + "@email.com'" + "}";

      String cql = String.format(
          "INSERT INTO users(user_name, fname, lname, emails) "
              + "VALUES ('%s', '%s', '%s',  %s);",
          user_name, fname, lname, emails);
      logger.debug("### " + cql);

      session.execute(cql);
    }
    long t2 = System.currentTimeMillis();

    logger.info(
        "".format("### Inserted %s users in %s milli secs. (%s writes / sec)",
            nf.format(maxUsers), 
            nf.format(t2 - t1),
            nf.format(maxUsers * 1000.0 / (t2 - t1))));

    session.close();
    cluster.close();
  }

}
