package com.es.cassandra;

import java.text.NumberFormat;
import java.util.logging.SimpleFormatter;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class Insert {

    public static void main(String[] args) throws Exception {

	Cluster cluster = Cluster.builder().addContactPoint("localhost")
		.build();
	System.out.println("### connected to " + cluster.getClusterName());

	Session session = cluster.connect("myflix");

	long t1 = System.currentTimeMillis();
	int maxUsers = 10; // change this to adjust # of records inserted
	for (int i = 1; i < maxUsers; i++) {
	    String user_name = "user-" + i;
	    String fname = "Joe " + i;
	    String lname = "Smith " + i;
	    String emails = "[" + "'user-" + i + "@email.com'" + "]";

	    // construct CQL
	    String cql = "".format(
		    "INSERT INTO users(user_name, fname, lname, emails) "
			    + "VALUES ('%s', '%s', '%s',  %s);", user_name,
		    fname, lname, emails);

	    // debug print, turn off for benchmarking :-)
	    System.out.println("### " + cql);

	    // TODO : execute cql in session
	    // session......(cql)
	}
	long t2 = System.currentTimeMillis();

	System.out.println("".format(
		"### Inserted %d users in %d milli secs. (%f writes / sec)",
		maxUsers, (t2 - t1), maxUsers * 1000.0 / (t2 - t1)));

	session.close();
	cluster.close();
    }

}
