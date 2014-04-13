package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class TestConnection {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session session = cluster.connect("myflix");
    System.out.println("session initialized to " + session.getLoggedKeyspace());

    session.close();
    cluster.close();

  }

}
