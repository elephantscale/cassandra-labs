package com.es.cassandra;

import java.text.NumberFormat;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class QueryAnswer {
  
  private static final Logger logger = LoggerFactory.getLogger(QueryAnswer.class);

  public static void main(String[] args) throws Exception {
    NumberFormat nf = NumberFormat.getInstance();

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    logger.info("### connected to " + cluster.getClusterName());

    Session session = cluster.connect("myflix");

    long t1 = System.currentTimeMillis();
    ResultSet resultSet = session.execute("select * from users");
    long t2 = System.currentTimeMillis();

    long t3 = System.currentTimeMillis();
    int numRows = 0;
    for (Row row : resultSet) {
      numRows++;
      logger.info("\n###" + numRows);
      logger.info("### user_name : " + row.getString("user_name"));

      // get email as a list
      Set<String> emails = row.getSet("emails", String.class);
      logger.info("### emails : " + emails);
    }
    long t4 = System.currentTimeMillis();

    session.close();
    cluster.close();

    logger.info("### select query took " + nf.format(t2 - t1) + " ms");
    logger.info(
        String.format("### Queried %s users in %s milli secs. (%s reads / sec)",
            nf.format(numRows), 
            nf.format(t2 - t1),
            nf.format(numRows * 1000.0 / (t2 - t1))));

  }

}
