package com.es.cassandra;

import java.text.NumberFormat;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

/*
 CREATE TABLE users (
 user_name text,
 fname text,
 lname text,
 emails Set<text>,
 password text,
 created_date timestamp,
 PRIMARY KEY (user_name)
 );
 */

public class Query {
  private static final Logger logger = LoggerFactory.getLogger(Query.class);

  public static void main(String[] args) throws Exception {
    NumberFormat nf = NumberFormat.getInstance();

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    logger.info("connected to " + cluster.getClusterName());

    // TODO-1 : Connect to keyspace
    Session session = cluster.connect("???");

    // TODO-2 : construct the cql for selecting all entries from USERS table
    long t1 = System.currentTimeMillis();
    ResultSet resultSet = session.execute("select ???? ");
    int numRows = 0;
    for (Row row : resultSet) {
      numRows++;
      // TODO : extract attributes. row.getString(...);
      logger.info("### user_name : " + row.getString("user_name"));
      logger.info("### fname : " + row.getString("???"));

      // TODO bonus : get email Set
      // Hint : Refer to JavaDocs for 'Row' for the correct 'get...'
      // Set<String> emails = row.getSet("???", String.class);
      // logger.info("### emails : " + emails);
    }
    long t2 = System.currentTimeMillis();

    logger.info(
        String.format("### Queried %s users in %s milli secs. (%s reads / sec)",
            nf.format(numRows),
            nf.format(t2 - t1),
            nf.format(numRows * 1000.0 / (t2 - t1))));

    session.close();
    cluster.close();
  }

}
