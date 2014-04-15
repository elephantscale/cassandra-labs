package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class AsyncQueryAnswer {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = cluster.connect ("myflix");

    long t1 = System.currentTimeMillis();
    // Async call is non-blocking
    ResultSetFuture results = session.executeAsync("select * from features");
    long t2 = System.currentTimeMillis();

    int counter = 0;
    for (Row row : results.getUninterruptibly())
    {
      System.out.println("\n" + counter++);
      System.out.println ("code : " + row.getString("code"));
      System.out.println ("name : " + row.getString("name"));
    }

    session.close();
    cluster.close();

    System.out.println ("-- async query took " + (t2-t1) + " ms");
  }

}
