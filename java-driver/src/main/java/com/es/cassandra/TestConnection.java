package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class TestConnection {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("### connected to " + cluster.getClusterName());

    // TODO : create a session by connecting to your keyspace
    Session  session = cluster.connect ("test");

    System.out.println("### session initialized to " + session.getLoggedKeyspace());

    session.close();
    cluster.close();

  }

}
