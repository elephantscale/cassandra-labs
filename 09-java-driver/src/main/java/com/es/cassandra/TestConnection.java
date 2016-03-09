package com.es.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class TestConnection {

    public static void main(String[] args) throws Exception {

	Cluster cluster = Cluster.builder().addContactPoint("localhost")
		.build();

	Metadata metadata = cluster.getMetadata();
	System.out.printf("### Connected to cluster: %s\n",
		metadata.getClusterName());

	System.out.println("### Hosts:");
	for (Host host : metadata.getAllHosts()) {
	    System.out.printf("###    Host: %s, Rack: %s,  Datacenter: %s \n",
		    host.getAddress(), host.getRack(), host.getDatacenter());
	}

	// TODO : create a session by connecting to your keyspace
	Session session = cluster.connect("???");

	System.out.println("### session initialized to "
		+ session.getLoggedKeyspace());

	session.close();
	cluster.close();

    }

}
