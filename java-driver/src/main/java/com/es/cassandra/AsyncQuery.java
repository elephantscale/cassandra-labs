package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class AsyncQuery {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = null;
    // TODO : connect to keyspace
    // session = cluster. ......

    // Async call is non-blocking
    // TODO : construct the cql for selecting all entries from USERS table
    ResultSetFuture results = session.executeAsync("..cql query...");

    // TODO : iterate over results , check JavaDoc
    // Hint : getUninterruptibly()


    session.close();
    cluster.close();

    // TODO : calculate how much time it took to execute the async  query
    // HINT :
    //  long t1 = System.currentTimeMillis();
    //  ... query ....
    //  long t2 =  System.currentTimeMillis();

  }

}
