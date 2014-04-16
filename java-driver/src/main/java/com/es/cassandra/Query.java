package com.es.cassandra;

import com.datastax.driver.core.Cluster;


import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class Query {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = cluster.connect ("myflix");

    // TODO : construct the cql for selecting all entries from USERS table
    ResultSet resultSet = session.execute(".....");
    for (Row row : resultSet)
    {
        // TODO : extract attributes.   row.getString(...);
      System.out.println ("user_name : " + row.getString("....."));
    }

    session.close();
    cluster.close();

    // TODO : calculate how much time it took to execute the query
    // HINT :
    //  long t1 = System.currentTimeMillis();
    //  ... query ....
    //  long t2 =  System.currentTimeMillis();
  }

}
