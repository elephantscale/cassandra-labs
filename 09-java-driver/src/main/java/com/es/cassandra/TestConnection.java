package com.es.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

// Javadocs : http://www.datastax.com/drivers/java/2.0/index.html

public class TestConnection {
  
  private static final Logger logger = LoggerFactory.getLogger(TestConnection.class);

  public static void main(String[] args) throws Exception {

    Cluster cluster = Cluster.builder().addContactPoint("localhost").build();

    Metadata metadata = cluster.getMetadata();
    logger.info("### Connected to cluster: {}\n",
        metadata.getClusterName());

    logger.info("### Hosts:");
    for (Host host : metadata.getAllHosts()) {
      logger.info("###    Host: {}, Rack: {},  Datacenter: {} \n",
          host.getAddress(), host.getRack(), host.getDatacenter());
    }

    // TODO : create a session by connecting to your keyspace
    Session session = cluster.connect("???");

    logger.info("### session initialized to " + session.getLoggedKeyspace());

    session.close();
    cluster.close();

  }

}
