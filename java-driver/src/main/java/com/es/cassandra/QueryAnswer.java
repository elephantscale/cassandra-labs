package com.es.cassandra;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class QueryAnswer {

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
    System.out.println("connected to " + cluster.getClusterName());

    Session  session = cluster.connect ("myflix");

    long t1 = System.currentTimeMillis();
    ResultSet resultSet = session.execute("select * from users");
    long t2 = System.currentTimeMillis();

    int counter = 0;
    for (Row row : resultSet)
    {
        System.out.println("\n" + counter++);
        System.out.println ("user_name : " + row.getString("user_name"));
    }

    session.close();
    cluster.close();

    System.out.println ("-- select query took " + (t2-t1) + " ms");
  }

}
