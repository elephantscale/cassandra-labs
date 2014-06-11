package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class InsertAnswer {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = cluster.connect ("myflix");

    for (int i = 1; i < 1000; i++)
    {
      String user_name = "user-" + i;
      String fname = "Joe-" + i;
      String emails = "[" + "'user-" + i + "@email.com'" + "]";

      String cql = "".format("INSERT INTO users(user_name, fname, emails) " +
      		"VALUES ('%s', '%s', %s);", user_name, fname, emails);
      System.out.println (cql);

      session.execute(cql);
    }

    session.close();
    cluster.close();
  }

}
