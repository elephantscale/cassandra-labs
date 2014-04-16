package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class Insert {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = null;
    // TODO : connect to keyspace
    // session = cluster.connect ("myflix");

    for (int i = 1; i < 10; i++)
    {
      String user_name = "user-" + i;
      String emails = "[" + "'user-" + i + "@email.com'" + "]";

      // TODO : construct a cql statement like the follows
      //   insert into users(....) VALUES (......)
      String cql = "INSERT INTO users(.......)";
      System.out.println (cql);

      // TODO : execute cql in session
      // session.execute(cql);
    }

    session.close();
    cluster.close();
  }

}
