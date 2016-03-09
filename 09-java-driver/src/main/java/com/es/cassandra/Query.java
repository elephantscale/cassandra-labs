package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

/*
 CREATE TABLE users (
 user_name text,
 fname text,
 lname text,
 emails list<text>,
 password text,
 created_date timestamp,
 PRIMARY KEY (user_name)
 );
 */

public class Query {

    public static void main(String[] args) throws Exception {

	Cluster cluster = Cluster.builder().addContactPoint("localhost")
		.build();
	System.out.println("connected to " + cluster.getClusterName());

	Session session = cluster.connect("myflix");

	// TODO : construct the cql for selecting all entries from USERS table
	long t1 = System.currentTimeMillis();
	ResultSet resultSet = session.execute("select ..... ");
	int numRows = 0;
	for (Row row : resultSet) {
	    numRows++;
	    // TODO : extract attributes. row.getString(...);
	    System.out.println("### user_name : " + row.getString("user_name"));
	    System.out.println("### fname : " + row.getString("???"));

	    // TODO bonus : print emails
	    // Hint : Refer to JavaDocs for 'Row' for the correct 'get...'
	    // method
	}
	long t2 = System.currentTimeMillis();

	System.out.println("".format(
		"### Queried %d users in %d milli secs. (%f reads / sec)",
		numRows, (t2 - t1), numRows * 1000.0 / (t2 - t1)));

	session.close();
	cluster.close();
    }

}
