package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class TestConnection {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    // TODO : create a session by connecting to cluster
    Session  session = cluster.connect (args[0]);

    // TODO : print out some session details
    System.out.println("session initialized to " + session.getLoggedKeyspace());

    // TODO : close the session
    session.close();

    cluster.close();

  }

}
