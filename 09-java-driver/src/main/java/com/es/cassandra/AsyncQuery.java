package com.es.cassandra;

import java.text.NumberFormat;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class AsyncQuery {

  public static void main(String[] args) throws Exception {
    NumberFormat nf = NumberFormat.getInstance();

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    // TODO-1 : connect to keyspace
    Session session = cluster.connect("???");

    // Async call is non-blocking
    // TODO-2 : construct the cql for selecting all entries from USERS table
    long t1 = System.currentTimeMillis();
    ResultSetFuture results = session.executeAsync("??? cql query here ???");
    long t2 = System.currentTimeMillis();

    int counter = 0;
    long t3 = System.currentTimeMillis();
    for (Row row : results.getUninterruptibly()) // this is blocking call
    {
      counter++;
      System.out.println("\n### " + counter);
      System.out.println("### user_name : " + row.getString("user_name"));
    }
    long t4 = System.currentTimeMillis();

    System.out.println("### async query took : " + nf.format(t2 - t1) + "  ms");
    System.out.println(String.format(
        "### Iterated through %s users in %s milli secs. (%s reads / sec)",
        nf.format(counter),
        nf.format(t4 - t3),
        nf.format(counter * 1000.0 / (t4 - t3))));

    session.close();
    cluster.close();

  }

}
